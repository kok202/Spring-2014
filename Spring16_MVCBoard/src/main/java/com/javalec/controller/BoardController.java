package com.javalec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.command.BoardCommand;
import com.javalec.command.BoardContentCommand;
import com.javalec.command.BoardDeleteCommand;
import com.javalec.command.BoardListCommand;
import com.javalec.command.BoardModifyCommand;
import com.javalec.command.BoardReplyCommand;
import com.javalec.command.BoardReplyPageCommand;
import com.javalec.command.BoardWriteCommand;

@Controller
public class BoardController {
	
	
	
	@RequestMapping("list")
	public String list(Model model){
		BoardCommand command = new BoardListCommand();
		command.execute(model);
		return "list";
	}
	
	
	
	@RequestMapping("writePage")
	public String writePage(Model model){
		return "writePage";
	}
	
	
	
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("contentPage")
	public String contentPage(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardContentCommand();
		command.execute(model);
		return "contentPage";
	}
	
	
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardModifyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("replyPage")
	public String replyPage(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardReplyPageCommand();
		command.execute(model);
		return "replyPage";
	}
	
	
	
	@RequestMapping("reply")
	public String reply(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardReplyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model){
		model.addAttribute("request", request);
		BoardCommand command = new BoardDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}
}
