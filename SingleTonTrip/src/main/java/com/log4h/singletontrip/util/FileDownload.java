package com.log4h.singletontrip.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownload extends AbstractView {

	public void Download() {

		setContentType("application/download; utf-8");

	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// downloadFile이라고 저장된 파일을 가져와 file에 할당
		File file = (File) model.get("downloadFile");
		
		//파일 다운을 위한 contentType 설정
		response.setContentType(getContentType());
		//다운로드 되는 파일의 크기 설정
		response.setContentLength((int) file.length());

		//Content-Disposition 헤더를 이용하여 전송되는 파일의 이름 명시
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\";");
		//Content-Transfer-Encoding 헤더를 이용하여 전송되는 데이터의 인코딩이 binary라고 명시
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//헤더 설정후 response의 OutputStream에 파일 전송
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//response의 OutputStream의 버퍼에 저장된 데이터를 전송
		out.flush();

	}
}