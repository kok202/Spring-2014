package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.data.StudentInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	
	
	@RequestMapping(value = "/studentIdOnly", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		String temp = request.getParameter("studentId");
		if (temp.equals("kok202"))
		{
			model.addAttribute("studentId", temp);
			return "redirect:studentPass";
		}
		return "redirect:studentFail";
	}
	
	
	
	@RequestMapping(value = "/studentData")
	public String home(@ModelAttribute("infoTo") StudentInfo infoFromForm) {
		return "showStudentData";
	}
	
	
	
	@RequestMapping("/studentPass")
	public String studentPassMethod(Model model){
		// redirect과정에서 model에 저장된 값을 잃어버립니다.
		return "showStudentId";
	}
	
	
	
	@RequestMapping("/studentFail")
	public String studentFailMethod(Model model){
		return "showFail";
	}
	
	
	
	
}
