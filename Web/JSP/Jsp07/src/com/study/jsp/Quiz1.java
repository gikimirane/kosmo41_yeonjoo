package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
		
		int num11, num22;
		int result = 0;
		
		request.setCharacterEncoding("UTF-8");
			
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			String calc = request.getParameter("calc");
			
			num11 = Integer.parseInt(num1); //String 형을 int형으로 형변환하는 작업
			num22 = Integer.parseInt(num2);
			
			if(calc.equals("+")) { // 들어온 값과 문자열을 비교
				result = num11 + num22;
			} else if(calc.equals("-")) {
				result = num11 - num22;
			} else if(calc.equals("*")) {
				result = num11 * num22;
			} else if(calc.equals("/")) {
				result = num11 / num22;
			}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println(num11 + " " + calc + " " + num22 + "의" + "<br>");
		writer.println("연산결과는 " + result + " 입니다" + "<br>");
		writer.println("</body></html>");
	
	}
}
