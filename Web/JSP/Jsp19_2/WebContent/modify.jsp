<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.Connection" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	Connection con;
		Statement stmt;
		ResultSet rs;
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "tiger";
		String query = "select * from member";
		
		String name, id, pw, phone1, phone2, phone3, gender;
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP/Servlet19-2 수정</title>
		
		<script src="http://code.jquery.com/jquery.js"></script>	
	
	<script>
		function form_check() {
			submit_ajax();
		}
	
		function submit_ajax(){
			var queryString = $("#ModifyProcess").serialize() ;
			$.ajax({
				url : '/Jsp19_2/ModifyProcess',
				type : 'POST',
				data : queryString,
				datatype : 'json',
				success : function(json){
					var results = eval(json);
					if(results[0].result == "ok"){
						alert("회원 정보 수정이 정상처리되었습니다.")
						window.location.replace("modifyResult.jsp");
					} else {
						alert(results[0].desc);
					}	
		
				}
			});
		}
	</script>
	</head>
	<body>
		
		<%
			id = (String)session.getAttribute("id");
		
			String query = "select * from member where id = '" + id + "'";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			String phone = "";
			while(rs.next()) {
				name = rs.getString("name");
				pw = rs.getString("pw");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
			}
			
			phone1 = phone.substring(0,3);
			phone2 = phone.substring(4,8);
			phone3 = phone.substring(9,13);
		%>
		
		<form name="ModifyProcess" id="ModifyProcess">
			아&nbsp;이&nbsp;디 : <%= id %><br>
			비밀번호 : <input type="text" name="pw" size="10"><br>
			이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름 : <input type="text" name="name" size="10" value=<%=name %>><br>
			전화번호 :  <select name="phone1">
			 	<option value="010">010</option>
			 	<option value="016">016</option>
			 	<option value="017">017</option>
			 	<option value="018">018</option>
			 	<option value="019">019</option>
			 	<option value="011">011</option>
			 </select> - 
			 <input type="text" name="phone2" size="5" value=<%=phone2 %>> -
			 <input type="text" name="phone3" size="5" value=<%=phone3 %>> <br>
			 
			 <%
				  if(gender.equals("woman")) {
			 %>
			 
			성별구분 : <input type="radio" name="gender" value="woman" checked="checked"> 여 &nbsp;
					   <input type="radio" name="gender" value="man"> 남 <br>
			<%
				  } else {
			%>
			성별구분 : <input type="radio" name="gender" value="woman" > 여 &nbsp;
					   <input type="radio" name="gender" value="man" checked="checked"> 남 <br>
			<%
				  }
			%>
			 <input type="button" value="정보수정" onclick="form_check()" />	 
		</form>
		
	</body>
</html>