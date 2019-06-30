package com.javalec.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.dao.BoardDAO;
import com.javalec.dto.BoardDTO;

public class BoardContentCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String boardId= request.getParameter("bId");

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentPage(boardId);

		model.addAttribute("contentPageFromCommand", dto);
	}

}
