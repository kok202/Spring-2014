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
		model.addAttribute("id", "Controller���� ��� �� �� model ��ü�� ���� ��������.");
		return "board/content";
	}
	
	
	
	@RequestMapping("/board/reply")
	public ModelAndView reply()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", "Controller���� ��� ����� ������ �� view�� model�� �Բ� �����Ѵ�.");
		modelAndView.setViewName("board/reply");
		return modelAndView;
	}
}