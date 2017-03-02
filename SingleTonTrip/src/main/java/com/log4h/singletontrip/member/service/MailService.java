package com.log4h.singletontrip.member.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.log4h.singletontrip.member.domain.FindVo;
import com.log4h.singletontrip.member.repository.MemberDao;

@Component
public class MailService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	protected JavaMailSender mailSender;

	// 아이디찾기
	public int SendId(String memberNm, String memberEmail) {
		String subject = "";
		String text = "";
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNm", memberNm);
		map.put("memberEmail", memberEmail);
		FindVo findVo = memberDao.memberIdFind(map);
		MimeMessage msg = mailSender.createMimeMessage();
		subject = findVo.getMemberNm() + "님 SingleTonTrip 아이디 찾기입니다.";
		text = findVo.getMemberNm() + "님의 아이디는" + findVo.getMemberId() + "입니다";
		try {
			msg.setSubject(subject);
			msg.setText(text);
			msg.setRecipient(RecipientType.TO, new InternetAddress(findVo.getMemberEmail()));
			mailSender.send(msg);
			result = 1;
		} catch (MessagingException e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

	// 비밀번호찾기
	@Transactional
	public int SendPw(String memberNm, String memberEmail, String memberId) {
		String subject = "";
		String text = "";
		String randomPw = getRandomPassword();
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNm", memberNm);
		map.put("memberEmail", memberEmail);
		map.put("memberId", memberId);
		map.put("randomPw", randomPw);
		FindVo findVo = memberDao.memberPwFind(map);
		if(findVo!=null){
			int pwUpdateResult = memberDao.memberPwUpdate(map);
			if(pwUpdateResult>0){
				MimeMessage msg = mailSender.createMimeMessage();
				subject = findVo.getMemberNm() + "님 SingleTonTrip 비밀번호 찾기입니다.";
				text = findVo.getMemberNm() + "님의 비밀번호는" + randomPw + "입니다";
				try {
					msg.setSubject(subject);
					msg.setText(text);
					msg.setRecipient(RecipientType.TO, new InternetAddress(findVo.getMemberEmail()));
					mailSender.send(msg);
					result = 1;
				} catch (MessagingException e) {
					e.printStackTrace();
					result = 0;
				}
			}
		}
		return result;
	}
	
	//랜덤 비밀번호 생성
	public String getRandomPassword(){
        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k',
        		'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        		'0','1','2','3','4','5','6','7','8','9'};
        
        StringBuilder sb = new StringBuilder("");
        Random rn = new Random();
        for( int i = 0 ; i < 8 ; i++ ){
            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
        }
        return sb.toString();
    }
}
