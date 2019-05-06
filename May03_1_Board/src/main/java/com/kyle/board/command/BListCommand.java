package com.kyle.board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.kyle.board.dao.bDao;
import com.kyle.board.dto.bDto;

public class BListCommand implements boardCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		bDao dao = new bDao();
		ArrayList<bDto>dtos = dao.list();
		model.addAttribute("list",dtos);
	}
}
