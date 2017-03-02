package com.log4h.singletontrip.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {

	public String uploadImage(MultipartFile imgFile) {
		// cafe24 절대 경로 /home/hosting_users/본인ID/www/디렉토리
		String realPath = "D:\\sts\\SingleTonTrip\\SingleTonTrip\\src\\main\\webapp\\images\\";
		String uploadPath = null;
		String imgName = null;
		String extension = null;
		File destFile = null;
		try {
			imgName = imgFile.getOriginalFilename();
			if (!imgName.equals("")) {
				int index = imgName.lastIndexOf(".");
				extension = "." + imgName.substring(index + 1);
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
}
