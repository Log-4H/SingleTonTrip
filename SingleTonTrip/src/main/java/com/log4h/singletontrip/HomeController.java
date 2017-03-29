package com.log4h.singletontrip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView profile(){
		ModelAndView mv = new ModelAndView("profile");
		return mv;
	}
	
	@RequestMapping(value="intro", method=RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView("intro");
		return mv;
	}
	@RequestMapping(value="error", method=RequestMethod.GET)
	public ModelAndView error(){
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}

}
