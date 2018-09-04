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
			loginOK(request,response);	
			
		} else if (command.equals("/modifyOK.do")) {
			modifyOK(request,response);
			
			
		} else if (command.equals("/joinOK.do")) {
			joinOK(request,response);
		} else if (command.equals("/logout.do")) {
			logoutOK(request,response);
		} 
	}
	
	public void loginOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("loginOK");
		request.setCharacterEncoding("UTF-8"); 
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.userCheck(id, pw);
		
		if(checkNum == -1) {
		
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"아이디가 존재하지 않습니다.\");"
					+ "history.go(-1); </script>");
			writer.close();		
		
		} else if(checkNum == 0) {
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"패스워드가 틀립니다.\");"
					+ "history.go(-1); </script>");
			writer.close();
			
		} else if(checkNum == 1) {		
			MemberDto dto = dao.getMember(id);
					  
			if(dto == null) {
				
				writer.println("<script language=\"javascript\" >"
						+ "alert(\"존재하지 않는 회원입니다.\");"
						+ "history.go(-1); </script>");
				writer.close();
				
			} else {
				String name = dto.getName();
				
				HttpSession session = request.getSession();
				
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main.jsp");
			}
				
		}
	}
	
	public void modifyOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("modifyOK");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDto dto = new MemberDto();
		
		HttpSession session = request.getSession();
	
		String id = (String)session.getAttribute("id");
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(eMail);
		System.out.println(pw);
		System.out.println(address);
	
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.seteMail(eMail);
		dto.setAddress(address);
		
		MemberDao dao = MemberDao.getInstance();
		int ri = dao.updateMember(dto);

		if(ri == 1) {
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"정보가 수정되었습니다.\");"
					+ "document.location.href=\"main.jsp\";</script>");
			
			writer.close();
		
		} else {	
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"정보수정에 실패했습니다..\");"
					+ "history.go(-1); </script>");
			writer.close();
		} 
		
	}
	
	public void joinOK (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("joinOK");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDto dto = new MemberDto();
		
		HttpSession session = request.getSession();
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(eMail);
		System.out.println(address);
	
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.seteMail(eMail);
		dto.setAddress(address);
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		
		MemberDao dao = MemberDao.getInstance();
		
		System.out.println(dto.getId());
		System.out.println(dao.confirmId(dto.getId()));
		
		if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {

			writer.println("<script language=\"javascript\" >"
					+ "alert(\"아이디가 이미 존재합니다.\");"
					+ "history.back();</script>");
			writer.close();
			
		} else {
			int ri = dao.insertMember(dto);
			if(ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				session.setAttribute("id", dto.getId());
		
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"회원가입을 축하합니다.\");"
					+ "document.location.href=\"login.jsp\";</script>");
			
			writer.close();
		} else {	
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"회원가입에 실패했습니다.\");"
					+ "document.location.href=\"join.jsp\";</script>");
			writer.close();
			
			}
		}
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
