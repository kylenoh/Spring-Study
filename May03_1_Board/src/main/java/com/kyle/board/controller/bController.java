package com.kyle.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyle.board.command.BWriteCommand;
import com.kyle.board.command.boardCommand;

@Controller
public class bController {
	
	boardCommand command;
	public JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@RequestMapping("/list")
	public String listModel(Model model) {
		
		return "list";
	}
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest req,Model model) {
		model.addAttribute("req",req);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest req,Model model) {
		
		return "content_view";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest req,Model model) {
		
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest req,Model model) {
		
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest req,Model model) {
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req,Model model) {
		
		return "redirect:list";
	}
}
