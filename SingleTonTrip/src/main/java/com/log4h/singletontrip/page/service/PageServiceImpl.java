package com.log4h.singletontrip.page.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.log4h.singletontrip.page.domain.PostVo;
import com.log4h.singletontrip.page.repository.PageDao;
import com.log4h.singletontrip.util.ImageUpload;

@Service
public class PageServiceImpl implements PageService{
	@Autowired
	private PageDao pageDao;

	//포스트리스트
	@Override
	public List<PostVo> postList(String memberId) {
		return pageDao.postList(memberId);
	}
	//포스트 등록
	@Override
	public int postAdd(PostVo postVo, MultipartFile imgFile) {
		ImageUpload imageUpload = new ImageUpload();
		String postImg = imageUpload.uploadImage(imgFile);
		if(postImg!=null){
		postVo.setPostImg(postImg);
		}
		int result = pageDao.postInsert(postVo);
		return result;
	}
}
