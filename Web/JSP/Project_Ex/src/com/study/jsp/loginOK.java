package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginOK implements Service {

	public loginOK() {
		
	}

	@Override
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
	
		System.out.println("loginOK");
		request.setCharacterEncoding("UTF-8"); 
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MDao mdao = MDao.getInstance();
		int checkNum = mdao.userCheck(mId, mPw);
		
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
			MDto dto = mdao.getMember(mId);
					  
			if(dto == null) {
				
				writer.println("<script language=\"javascript\" >"
						+ "alert(\"존재하지 않는 회원입니다.\");"
						+ "history.go(-1); </script>");
				writer.close();
				
			} else {
				String mName = dto.getmName();
				
				HttpSession session = request.getSession();
				
				session.setAttribute("mId", mId);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main.jsp");
			}
				
		}

	}

}
