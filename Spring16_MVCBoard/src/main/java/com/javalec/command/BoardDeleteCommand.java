package com.javalec.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BoardDAO;

public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest requset = (HttpServletRequest) map.get("request");
		String bId = requset.getParameter("bId");
		
		BoardDAO dao = new BoardDAO();
		dao.delete(bId);
	}

}
