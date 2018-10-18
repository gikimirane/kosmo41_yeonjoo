package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BDeleteCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.command.BWriteCommand;

@Controller
public class BController {
	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
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
		command = context.getBean(BContentCommand.class);
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("deleteHandler");
		command.execute(model);
		
		return "redurect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("modifyHandler");
		command.execute(model);
	
		return "redurect:content_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("replyHandler");
		command.execute(model);
	
		return "redurect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("replyViewHandler");
		command.execute(model);
	
		return "redurect:reply_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request",request);
		command = (BCommand) context.getBean("writeHandler");
		command.execute(model);
	
		return "redurect:list";
	}
	
}
