package com.log4h.singletontrip.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.post.domain.PostCommentVo;
import com.log4h.singletontrip.post.domain.PostVo;
import com.log4h.singletontrip.post.repository.PostDao;
import com.log4h.singletontrip.util.ImageUpload;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostDao postDao;

	//페이지레벨
	public String pageLevel(String pageId){
		return postDao.pageLevel(pageId);
	}
	//포스트 리스트
	@Override
	public List<PostVo> postList(String memberId, int lastPostRow) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("lastPostRow", lastPostRow);
		List<PostVo> postList = postDao.postList(map);
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
		int result = postDao.postInsert(postVo);
		return result;
	}
	
	//댓글 등록
	@Override
	public int postCommentAdd(int postNo, String memberId, String postCommentContent){
		PostCommentVo postCommentVo = new PostCommentVo();
		postCommentVo.setPostNo(postNo);
		postCommentVo.setMemberId(memberId);
		postCommentVo.setPostCommentContent(postCommentContent);
		int result = postDao.postCommentInsert(postCommentVo);
		return result;
	}
	
	//댓글 리스트
	@Override
	public List<PostCommentVo> postCommentList(int postNo, String memberId, int lastCommentRow) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("postNo", postNo);
		map.put("lastCommentRow", lastCommentRow);
		List<PostCommentVo> postCommentList = postDao.postCommentList(map);
		return postCommentList;
	}

	//포스트 댓글 삭제
	@Override
	public int postcommentDelete(int postCommentNo) {
		return postDao.postCommentDelete(postCommentNo);
	}

	//포스트 보기
	@Override
	public PostVo postView(int postNo) {
		PostVo postVo = postDao.postView(postNo);
		postVo.setPostContent(postVo.getPostContent().replaceAll("<br>", "\r\n"));
		return postVo;
	}

	//포스트 업데이트
	@Override
	public int postModify(int postNo, String postTitle, String postContent, MultipartFile imgFile) {
		String beforeImg = null;
		String afterImg = null;
		PostVo postVo = new PostVo();
		postVo = postDao.postView(postNo);
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
		int result = postDao.postUpdate(postVo);
		return result;
	}
	
	//포스트 삭제
	@Override
	public int postDelete(int postNo) {
		int result = postDao.postDelete(postNo);
		if(result>0){
			String beforeImg = null;
			PostVo postVo = new PostVo();
			postVo = postDao.postView(postNo);
			if(postVo.getPostImg()!=null){
				beforeImg = postVo.getPostImg();
				ImageUpload imageUpload = new ImageUpload();
				imageUpload.deleteImage(beforeImg);
			}
		}
		return result;
	}

}
