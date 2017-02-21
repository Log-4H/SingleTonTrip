package com.log4h.singletontrip.a.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {
	/*
	 * 모든 메소드의 리턴타입은 ModelAndView 로한다 (String 타입 x)
	 * 
	 * - ModelAndView mv = new ModelAndView(); 
	 *  : 메소드 첫 부분에 ModelAndView 생성하자. 필수 
	 *  : 매개변수에 Model model 넣을 필요없다.
	 *   
	 * - mv.addObject()
	 * 	: jsp에서 데이터를 받아야할땐 mv.addObject("view에서사용하는데이터명", 데이터변수이름) 하면된다.
	 * 
	 * - mv.setViewName()
	 * 	: url을 설정한다.
	 * 	: 포워딩 (view폴더 아래의 .jsp로 간다)
	 * 	  mv.setViewName("example/exampleAdd")
	 * 	: 리다이렉트(controller에 맵핑된 주소로간다.) 
	 * 	  mv.setViewName("redirect:example/exampleAdd")
	 */
	
	
	@Autowired
	private ExampleService exampleService;

	//insert 예제 -get방식
	@RequestMapping(value="exampleInsert", method=RequestMethod.GET)
	public ModelAndView insertExample(){
		//ModelAndView 객체 생성
		ModelAndView mv = new ModelAndView();
		//url을 설정해준다.
		mv.setViewName("example/exampleInsert");
		//설정한 url로 리턴 -> exampleInsert.jsp 로 간다
		return mv;	
	}
	
	//insert 포워딩 예제 - post방식
	@RequestMapping(value="exampleAdd", method=RequestMethod.POST)
	public ModelAndView insertExample(ExampleVo exampleVO){
		//ModelAndView 객체 생성
		ModelAndView mv = new ModelAndView();
		//service 호출 (insertExample : db에 데이터 insert 처리 메소드)
		int result = exampleService.insertExample(exampleVO);
		
		//insert 성공 여부에 따른 경로 설정
		if(result>0){
			//성공시 redirect -> controller 의 selectExample로 간다.
			mv.setViewName("redirect:example/exampleSelect");
		}else{
			//실패시 포워딩 -> error.jsp로 간다.
			mv.setViewName("example/error");
		}
		
		//설정된 경로로 간다.
		return mv;
	}
	
	//select 예제
	@RequestMapping(value="exampleSelect", method=RequestMethod.GET)
	public ModelAndView selectExample(
			@RequestParam(value="a") int a){
		//ModelAndView 객체 생성
		ModelAndView mv = new ModelAndView();
		//Service를 호출하여 exampleVO 객체에 담는다.
		ExampleVo exampleVO = exampleService.selectExample(a);
		//.jsp로 데이터를 보내기 위해 ModelAndView에 exampleVO를 담는다.
		mv.addObject("exampleVO", exampleVO);
		//url설정
		mv.setViewName("example/example");
		//설정된 경로로 간다.
		return mv;	
	}
}
