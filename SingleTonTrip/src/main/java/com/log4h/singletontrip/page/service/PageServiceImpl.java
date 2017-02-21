package com.log4h.singletontrip.page.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.page.repository.PageDao;

@Service
public class PageServiceImpl implements PageService{
	@Autowired
	private PageDao pageDao;
}
