package com.log4h.singletontrip.post.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.post.domain.PostCommentVo;
import com.log4h.singletontrip.post.domain.PostVo;

@Repository
public class PostDaoImpl implements PostDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String POST_NS = "postMapper.";
	
	//포스트리스트
	@Override
	public List<PostVo> postList(Map<String, Object> map) {
		return sqlSession.selectList(POST_NS+"postList", map);
	}
	
	//포스트등록
	@Override
	public int postInsert(PostVo postVo) {
		return sqlSession.insert(POST_NS+"postInsert", postVo);
	}
	//포스트 댓글리스트
	@Override
	public List<PostCommentVo> postCommentList(Map<String, Object> map) {
		return sqlSession.selectList(POST_NS+"postCommentList", map);
	}
	//포스트 댓글 등록
	@Override
	public int postCommentInsert(PostCommentVo postCommentVo) {
		return sqlSession.insert(POST_NS+"postCommentInsert", postCommentVo);
	}
	//포스트 댓글 삭제
	@Override
	public int postCommentDelete(int postCommentNo) {
		return sqlSession.update(POST_NS+"postCommentDelete", postCommentNo);
	}
	//포스트 보기
	@Override
	public PostVo postView(int postNo) {
		return sqlSession.selectOne(POST_NS+"postView", postNo);
	}
	//포스트 업데이트
	@Override
	public int postUpdate(PostVo postVo) {
		return sqlSession.update(POST_NS+"postUpdate", postVo);
	}
	//포스트 삭제
	@Override
	public int postDelete(int postNo) {
		return sqlSession.delete(POST_NS+"postDelete", postNo);
	}
}
