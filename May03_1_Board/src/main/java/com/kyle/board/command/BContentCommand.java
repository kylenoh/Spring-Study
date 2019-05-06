package com.kyle.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kyle.board.dao.bDao;
import com.kyle.board.dto.bDto;

public class BContentCommand implements boardCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map = model.asMap();
		HttpServletRequest req = (HttpServletRequest) map.get("req");
		
		String bId = req.getParameter("bId");
		bDao dao = new bDao();
		bDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view",dto);
	}
}
