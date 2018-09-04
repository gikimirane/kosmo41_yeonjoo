package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class modifyOK implements Service {

	public modifyOK() {
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
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
}
