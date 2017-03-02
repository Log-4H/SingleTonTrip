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

	//포스트 리스트
	@Override
	public List<PostVo> postList(String memberId, int lastPostRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("lastPostRow", lastPostRow);
		List<PostVo> postList = pageDao.postList(map);		
		return postList;
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
	public int postCommentAdd(int postNo, String memberId, String postCommentContent){
		PostCommentVo postCommentVo = new PostCommentVo();
		postCommentVo.setPostNo(postNo);
		postCommentVo.setMemberId(memberId);
		postCommentVo.setPostCommentContent(postCommentContent);
		int result = pageDao.postCommentInsert(postCommentVo);
		return result;
	}
	
	//댓글 리스트
	@Override
	public List<PostCommentVo> postCommentList(int postNo, String memberId, int lastCommentRow) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("postNo", postNo);
		map.put("lastCommentRow", lastCommentRow);
		List<PostCommentVo> postCommentList = pageDao.postCommentList(map);
		return postCommentList;
	}

	//포스트 댓글 삭제
	@Override
	public int postcommentDelete(int postCommentNo) {
		return pageDao.postCommentDelete(postCommentNo);
	}

	//포스트 보기
	@Override
	public PostVo postView(int postNo) {
		return pageDao.postView(postNo);
	}

	//포스트 업데이트
	@Override
	public int postModify(int postNo, String postTitle, String postContent, MultipartFile imgFile) {
		String beforeImg = null;
		String afterImg = null;
		PostVo postVo = new PostVo();
		postVo = pageDao.postView(postNo);
		if(postVo.getPostImg()!=null){
			beforeImg = postVo.getPostImg();
		}
		ImageUpload imageUpload = new ImageUpload();
		afterImg = imageUpload.uploadImage(imgFile);
		postVo.setPostNo(postNo);
		postVo.setPostTitle(postTitle);
		postVo.setPostContent(postContent.replaceAll("\r\n", "<br>"));	
		if(afterImg!=null){
			postVo.setPostImg(afterImg);
			if(beforeImg!=null){
				imageUpload.deleteImage(beforeImg);
			}
		}
		int result = pageDao.postUpdate(postVo);
		return result;
	}
}
