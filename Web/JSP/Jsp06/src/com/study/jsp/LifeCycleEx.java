package com.study.jsp;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleEx")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LifeCycleEx() {
		super();
		System.out.println("생성");
	}

	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("init");
	}


	public void destroy() 
	{
		System.out.println("destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
	}
	
	@PostConstruct
	private void initPostConstruct() {
		System.out.println("initPostConstruct (선처리 작업)");
	}
	
	@PreDestroy
	private void destoryPreDestory() {
		System.out.println("destoryPreDestory (후처리 작업)");
	}

}
