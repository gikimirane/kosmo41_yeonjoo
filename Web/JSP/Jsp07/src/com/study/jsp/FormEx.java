package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormEx")
public class FormEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String[] hobbys = request.getParameterValues("hobby");
		
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		//request는 parameter 값을 부를 때 사용
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("이름 :" + name + "<br>");
		writer.println("아이디 :" + id + "<br>");
		writer.println("비밀번호 :" + pw + "<br>");
		writer.println("취미 :" + Arrays.toString(hobbys) + "<br>");
		writer.println("전공 :" + major + "<br>");
		writer.println("프로토콜 :" + protocol);
		writer.println("</body></html>");
		
	}

}
