package com.log4h.singletontrip.page.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.log4h.singletontrip.page.domain.PostCommentVo;
import com.log4h.singletontrip.page.domain.PostVo;

@Repository
public class PageDaoImpl implements PageDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String PAGE_NS = "pageMapper.";
	
	//포스트리스트
	@Override
	public List<PostVo> postList(Map<String, Object> map) {
		return sqlSession.selectList(PAGE_NS+"postList", map);
	}
	
	//포스트등록
	@Override
	public int postInsert(PostVo postVo) {
		return sqlSession.insert(PAGE_NS+"postInsert", postVo);
	}
	//포스트 댓글리스트
	@Override
	public List<PostCommentVo> postCommentList(Map<String, Object> map) {
		return sqlSession.selectList(PAGE_NS+"postCommentList", map);
	}
	//포스트 댓글 등록
	@Override
	public int postCommentInsert(PostCommentVo postCommentVo) {
		return sqlSession.insert(PAGE_NS+"postCommentInsert", postCommentVo);
	}
	//포스트 댓글 삭제
	@Override
	public int postCommentDelete(int postCommentNo) {
		return sqlSession.update(PAGE_NS+"postCommentDelete", postCommentNo);
	}
	//포스트 보기
	@Override
	public PostVo postView(int postNo) {
		return sqlSession.selectOne(PAGE_NS+"postView", postNo);
	}
	//포스트 업데이트
	@Override
	public int postUpdate(PostVo postVo) {
		return sqlSession.update(PAGE_NS+"postUpdate", postVo);
	}
	//포스트 삭제
	@Override
	public int postDelete(int postNo) {
		return sqlSession.delete(PAGE_NS+"postDelete", postNo);
	}
}
