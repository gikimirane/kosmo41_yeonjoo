import java.sql.*;

public class TransactionEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"scott", 
					"tiger");
			
//			con.setAutoCommit(false); // 오토 커밋 방지용

		//------------------------------------------------
		String sql = "insert into test3 values('이선호','1111')";
		
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		System.out.println("11111");
		
		sql = "insert into test3 values('이민우','2222')";
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		System.out.println("22222");
	
		sql = "insert into test3 values('신혜성','3333'";  // )를 없애서 에러를 유도
		pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		System.out.println("33333");
		
		success = true;
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (success) {
					System.out.println("44444");
					con.commit();
				}else {
					System.out.println("55555");
					con.rollback();
				}
				
				if (pstmt != null)pstmt.close();
				if (con != null) con.close();
			} catch (SQLException sqle) {}

		}
		
		
	}

}
