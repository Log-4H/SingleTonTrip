package com.log4h.singletontrip.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {	
	//cafe24 경로
	private final String realPath = "/home/hosting_users/ymw0608/tomcat/webapps/ROOT/images/";
	//private final String realPath = "D:\\TeamProject\\git\\SingleTonTrip\\SingleTonTrip\\src\\main\\webapp\\images\\";
	
	//업로드 이미지
	public String uploadImage(MultipartFile imgFile){
		String uploadPath = null; //실제 저장되는 경로에 + 파일이름 
		String imgName = null; //파일이름
		String extension = null; //확장자
		File destFile = null; //저장파일

		try {
			imgName = imgFile.getOriginalFilename(); //파일의 원래이름을 가져온다.
			if(!imgName.equals("")){ //파일이 들어왔는지 체크
				int index = imgName.lastIndexOf("."); //확장자 구분을 위한 (.)인덱스 찾기
				extension = "."+imgName.substring(index+1); //. 뒤의 확장자를 저장
				UUID uuid = UUID.randomUUID(); //랜덤 파일이름 생성 (중복안되게)
				
				imgName = uuid.toString().replace("-", "") + extension; //파일이름 생성 1111111.jpg
				uploadPath = realPath + imgName; //저장될 경로 생성 (realpath + imgName) d:....11111.jpg
				destFile = new File(uploadPath); //최종파일을 업로드 패쓰에 업로드
				
				imgFile.transferTo(destFile); //?
			}
		} catch (IllegalStateException e) {
			destFile.delete(); //파일삭제
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete(); //파일삭제
			e.printStackTrace();
		}
		return imgName;	
	}
	
	//업로드 파일 삭제
	public void deleteImage(String postImg){		
		File destFile = new File(realPath + postImg);
		destFile.delete();
	}
}