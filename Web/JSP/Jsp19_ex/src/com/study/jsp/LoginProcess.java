package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		String id, pw, name, phone, gender;
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = "";
		phone = "";
		gender = "";
		
		String query = "select * from member where id = ? and pw = ?";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		boolean pwcheck = false;
		
		
		try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, uid, upw);
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
					
				// 결과데이터가 한개라면 while 대신 if를 사용해도 된다.
					
				while(rs.next()) {
					//id = rs.getString("id");
					//pw = rs.getString("pw");
					name = rs.getString("name");
					phone = rs.getString("phone");
					gender = rs.getString("gender");	
					
					pwcheck = true;
					
				}
					
				if(pwcheck) {
					
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					session.setAttribute("id", id);
					session.setAttribute("pw", pw);
			
					System.out.println("login success");
					writer.println( "[{\"result\":\"ok\",\"desc\":\"none\"}]" );
					
					writer.close();
				} else {
					
					System.out.println("login fail");
					writer.println( "[{\"result\":\"fail\",\"desc\":\"로그인에 실패하였습니다.\"}]" );
						
					writer.close();
					
				}
					
			} catch (Exception e) {
				
				System.out.println("login fail");
				writer.println( "[{\"result\":\"fail\",\"desc\":\"로그인 정보가 없습니다.\"}]" );
					
				writer.close();
					
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					}
			}
		
	}

}
