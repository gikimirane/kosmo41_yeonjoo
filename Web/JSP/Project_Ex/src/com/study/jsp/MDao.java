package com.study.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MDao {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MDao instance = new MDao();
	
	private MDao() {
		
	}
	
	public static MDao getInstance() {
		return instance;
	}
	
	public int insertMember(MDto mdto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into members values (?,?,?,?,?,?)";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, mdto.getId());
			pstmt.setString(2, mdto.getPw());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.geteMail());
			pstmt.setTimestamp(5, mdto.getrDate());
			pstmt.setString(6, mdto.getAddress());
			pstmt.executeUpdate();
			ri = MDao.MEMBER_JOIN_SUCCESS;
			
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
		
		return ri;
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				ri = MDao.MEMBER_EXISTENT;
			} else {
				ri = MDao.MEMBER_NONEXISTENT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id = ?";
		
		System.out.println("DaoOK");
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbPw = set.getString("pw");
				if(dbPw.equals(pw)) {
					System.out.println("login_OK");
					ri = MDao.MEMBER_LOGIN_SUCCESS; //로그인 OK
				} else {
					System.out.println("login fail(pw)");
					ri = MDao.MEMBER_LOGIN_PW_NO_GOOD; //비밀번호 X
				}
			} else {
				System.out.println("login fail(ID)");
				ri = MDao.MEMBER_LOGIN_IS_NOT; //아이디 X
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public MDto getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from members where id = ?";
		MDto mdto = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				mdto = new MDto();
				mdto.setId(set.getString("id"));
				mdto.setPw(set.getString("pw"));
				mdto.setName(set.getString("name"));
				mdto.seteMail(set.getString("eMail"));
				mdto.setrDate(set.getTimestamp("rDate"));
				mdto.setAddress(set.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return mdto;
	}
	
	public int updateMember(MDto mdto) {
		int ri = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?, eMail=?, address=? where id=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, mdto.getPw());
			System.out.println(mdto.getPw());
			pstmt.setString(2, mdto.geteMail());
			System.out.println(mdto.geteMail());
			pstmt.setString(3, mdto.getAddress());
			System.out.println(mdto.getAddress());
			pstmt.setString(4, mdto.getId());
			System.out.println(mdto.getId());
			
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	private Connection getConnection() {
		
		Context context = null;
		DataSource dataSource = null;
		Connection con = null;
		
		try {
			//lookup 함수의 파라미터는 context.xml에 설정된 name과 동일해야 한다.
			//[ "java:comp/env/jdbc/Oracle11g" ] 에서 [ jdbc/Oracle11g ] 이 부분이 이름 !
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}

