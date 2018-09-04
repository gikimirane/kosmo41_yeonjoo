package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MDao {
	
	private static MDao instance = new MDao();
	DataSource dataSource = null;
	
	private MDao() {
		try {
			//lookup 함수의 파라미터는 context.xml에 설정된 name과 동일해야 한다.
			//[ "java:comp/env/jdbc/Oracle11g" ] 에서 [ jdbc/Oracle11g ] 이 부분이 이름 !
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	public static MDao getInstance() {
		return instance;
	}
	
	public void insertMember(String mId, String mPw, String mName, String mEmail, String mAddress) 
		{
	
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into member_list values (?, ?, ?, ?, ?)";
	
		try {
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query); //DB에 쿼리문을 보냄
			
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			pstmt.setString(3, mName);
			pstmt.setString(4, mEmail);
			pstmt.setString(5, mAddress);
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void confirmId() {
		
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet resultSet =null; 
		
		try {
			
			con = dataSource.getConnection();
			
			String query = "select mId from member_list where mId = ?";
			 
			pstmt = con.prepareStatement(query); 
			resultSet = pstmt.executeQuery(); //쿼리문의 결과값을 담는 역할
				
			if(resultSet.next()) {
				String mId = resultSet.getString("mId");
		    }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
	public void userCheck(String mId, String mPw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		
		try {
			con = dataSource.getConnection();
			
			String query = "select mPw from members where id = ?";
			 
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				dbPw = resultSet.getString("mPw");
				if(dbPw.equals(mPw)) {
					System.out.println("login_OK"); //로그인 OK
				} else {
					System.out.println("login fail(pw)");
			 	
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	
	public MDto getMember(String id) {
		
		MDto mdto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			
			String query = "select * from member_list where id = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				String mId = resultSet.getString("mId");
				String mPw = resultSet.getString("mPw");
				String mName = resultSet.getString("mName");
				String mEmail = resultSet.getString("mEmail");
				String mAddress = resultSet.getString("mAddress");
				 
			mdto = new MDto(mId, mPw, mName, mEmail, mAddress);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return mdto;
		}
	
	public void updateMember(String mId, String mName, String mEmail, String mAddress) 
		{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String query = "update member_list" +
					   "   set mName = ?, " +
					   "       mEMail = ?, " +
					   "       mAddress = ? " +
					   " where mId = ?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, mName);
			pstmt.setString(2, mEmail);
			pstmt.setString(3, mAddress);
			pstmt.setString(4, mId);
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

