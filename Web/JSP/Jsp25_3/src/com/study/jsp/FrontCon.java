package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sun.xml.internal.txw2.Document;

import java.sql.Timestamp;
import com.study.jsp.MemberDao;
import com.study.jsp.MemberDto;

@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);
		
		if(command.equals("/loginOK.do")) {
			Service service = new loginOK();
			service.execute(request, response);
			
		} else if (command.equals("/modifyOK.do")) {
			Service service = new modifyOK();
			service.execute(request, response);
	
		} else if (command.equals("/joinOK.do")) {
			Service service = new joinOK();
			service.execute(request, response);
	
		} else if (command.equals("/logout.do")) {
			logoutOK(request,response);
		} 
		
	}
	
	public void loginOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{	
		System.out.println("loginOK");
	}
	
	public void modifyOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("modifyOK");
	}		
	
	public void joinOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("joinOK");
	}
	
	public void logoutOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("logout");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
}
