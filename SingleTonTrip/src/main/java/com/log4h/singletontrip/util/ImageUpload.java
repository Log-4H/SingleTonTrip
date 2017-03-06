package com.log4h.singletontrip.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {	
	//cafe24 경로
	//private final String realPath = "/home/hosting_users/rexolua/tomcat/webapps/SingleTonTrip/images/";
	private final String realPath = "D:\\TeamProject\\git\\SingleTonTrip\\SingleTonTrip\\src\\main\\webapp\\images\\";
	
	//업로드 이미지
	public String uploadImage(MultipartFile imgFile){
		String uploadPath = null;
		String imgName = null;
		String extension = null;
		File destFile = null;

		try {
			imgName = imgFile.getOriginalFilename();
			if(!imgName.equals("")){
				int index = imgName.lastIndexOf(".");
				extension = "."+imgName.substring(index+1);
				UUID uuid = UUID.randomUUID();
				
				imgName = uuid.toString().replace("-", "") + extension;
				uploadPath = realPath + imgName;
				destFile = new File(uploadPath);
				
				imgFile.transferTo(destFile);
			}
		} catch (IllegalStateException e) {
			destFile.delete(); 
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete();
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