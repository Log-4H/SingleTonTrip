package com.log4h.singletontrip.page.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.page.domain.PostVo;

public interface PageService {
	//포스트 리스트
	public List<PostVo> postList(String memberId);
	//포스트 등록
	public int postAdd(PostVo postVo, MultipartFile imgFile);
}
