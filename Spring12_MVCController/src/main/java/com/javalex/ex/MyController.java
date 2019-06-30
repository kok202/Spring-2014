package com.javalex.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/board/view")
	public String view()
	{
		return "board/view";
	}
	
	
	
	@RequestMapping("/board/content")
	public String content(Model model)
	{
		model.addAttribute("id", "Controller에서 뷰로 갈 때 model 객체를 같이 데려간다.");
		return "board/content";
	}
	
	
	
	@RequestMapping("/board/reply")
	public ModelAndView reply()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", "Controller에서 뷰로 가라고 지정할 때 view와 model을 함께 지정한다.");
		modelAndView.setViewName("board/reply");
		return modelAndView;
	}
}