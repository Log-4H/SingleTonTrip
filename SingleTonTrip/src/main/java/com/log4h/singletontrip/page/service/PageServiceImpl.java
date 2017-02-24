package com.log4h.singletontrip.page.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;
import com.log4h.singletontrip.page.repository.PageDao;
import com.log4h.singletontrip.util.ImageUpload;

@Service
public class PageServiceImpl implements PageService{
	@Autowired
	private PageDao pageDao;

	//포스트 & 댓글 리스트
	@Override
	public Map<String, Object> postList(String memberId, int beginRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("beginRow", beginRow);
		List<PostVo> postList = pageDao.postList(map);		
		List<PostCommentVo> postCommentList = pageDao.postCommentList(map);
		map.put("postList", postList);
		map.put("postCommentList", postCommentList);
		return map;
	}
	//포스트 등록
	@Override
	public int postAdd(PostVo postVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String postImg = imageUpload.uploadImage(imgFile);
		if(postImg!=null){
		postVo.setPostImg(postImg);
		}
		postVo.setPostContent(postVo.getPostContent().replaceAll("\r\n", "<br>"));
		int result = pageDao.postInsert(postVo);
		return result;
	}
	
	//댓글 등록
	@Override
	public List<PostCommentVo> postCommentAdd(int postNo, String memberId, String postCommentContent){
		PostCommentVo postCommentVo = new PostCommentVo();
		postCommentVo.setPostNo(postNo);
		postCommentVo.setMemberId(memberId);
		postCommentVo.setPostCommentContent(postCommentContent);
		int result = pageDao.postCommentInsert(postCommentVo);
		List<PostCommentVo> commentList = null;
		if(result>0){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("memberId", memberId);
			map.put("postNo", postNo);
			commentList = pageDao.postCommentList(map);
		}
		return commentList;
	}
	
}
