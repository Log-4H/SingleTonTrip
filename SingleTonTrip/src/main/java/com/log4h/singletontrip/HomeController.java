package com.log4h.singletontrip;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView profile(){
		ModelAndView mv = new ModelAndView("profile");
		return mv;
	}
	
	@RequestMapping(value="intro", method=RequestMethod.GET)
	public ModelAndView intro(){
		ModelAndView mv = new ModelAndView("intro");
		return mv;
	}
	@RequestMapping(value="error", method=RequestMethod.GET)
	public ModelAndView error(){
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}
	@RequestMapping(value="manual", method=RequestMethod.GET)
	public ModelAndView manual(){
		ModelAndView mv = new ModelAndView("manual");
		return mv;
	}
	@RequestMapping(value = "fileDownload", method = RequestMethod.GET)
	public ModelAndView fileDownload(@RequestParam("fileName") String fileName){
		//프로젝트 테스트용
		//String path = "D:\\TeamProject\\git\\SingleTonTrip\\SingleTonTrip\\src\\main\\webapp\\file\\" + fileName;
		//cafe24 경로
		String path = "/home/hosting_users/ymw0608/tomcat/webapps/ROOT/file/"  + fileName;
		File file = new File(path);
		return new ModelAndView("download", "downloadFile", file);
	}
}
