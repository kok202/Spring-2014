package com.javalec.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.dao.BoardDAO;
import com.javalec.dto.BoardDTO;

public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(Model model) {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos = dao.list();
		model.addAttribute("dtosFromCommand", dtos);
	}

}
