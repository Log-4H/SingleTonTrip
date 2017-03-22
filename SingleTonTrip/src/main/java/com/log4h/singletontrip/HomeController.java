package com.log4h.singletontrip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="main", method=RequestMethod.GET)
	public ModelAndView main(){
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
	@RequestMapping(value="post", method=RequestMethod.GET)
	public ModelAndView post(){
		ModelAndView mv = new ModelAndView("post");
		return mv;
	}
	@RequestMapping(value="intro", method=RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView("intro");
		return mv;
	}
	@RequestMapping(value="test", method=RequestMethod.GET)
	public ModelAndView error(){
		ModelAndView mv = new ModelAndView("test/body");
		return mv;
	}
	@RequestMapping(value="login2", method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("test/login");
		return mv;
	}
	@RequestMapping(value="main2", method=RequestMethod.GET)
	public ModelAndView main2(){
		ModelAndView mv = new ModelAndView("test/main2");
		return mv;
	}
}
