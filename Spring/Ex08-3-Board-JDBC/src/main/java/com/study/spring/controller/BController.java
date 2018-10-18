package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BWriteCommand;
import com.study.spring.util.Constant;

@Controller
public class BController {
	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template =template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = context.getBean(BListCommand.class);
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		System.out.println("content_view()");

		model.addAttribute("request",request);
		command = (BContentCommand)context.getBean("contentHandler");
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("deleteHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command = (BModifyCommand) context.getBean("modifyHandler");
		command.execute(model);
	
		return "content_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("replyHandler");
		command.execute(model);
	
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("replyViewHandler");
		command.execute(model);
	
		return "reply_view";
	}
	
	@RequestMapping("/write_view")
	public String writeView(HttpServletRequest request, Model model) {	
		return "write_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request",request);
		command = (BWriteCommand) context.getBean("writeHandler");
		command.execute(model);
	
		return "redirect:list";
	}
	
	
	
}
