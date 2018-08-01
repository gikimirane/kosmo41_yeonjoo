import java.sql.*;

//JDBC 2.0 : excuteBatch()
// INSERT,UPDATE, DELETE, CREATE, DROP, ALTER 등에서만 사용할 수 있다.

public class BatchInsertEx {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1.JDBC 드라이버 로딩
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean commit = false;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",  // * jdbc:oracle:thin:@HOST:PORT:SID 순서
					"scott", 
					"tiger");                      // 2. 데이터베이스 커넥션 구함
			
			stmt = con.createStatement();    // 3. 쿼리 실행을 위한 Statement 객체 생성
			sql = "create table test4 ( " +
			      "    id varchar2(10), " +
				  "    password varchar2(10) )";
			stmt.executeUpdate(sql);
			
			con.setAutoCommit(false);
			
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('문정혁', '1111')");
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('이민우', '2222')");
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('김동완', '3333')");
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('신혜성', '4444')");
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('전  진', '5555')");
			stmt.addBatch("INSERT INTO test4 " +
			        "VALUES('이선호', '6666')");
			
			int [] updateCounts = stmt.executeBatch();
			commit = true;
			con.commit();
			
			rs = stmt.executeQuery("select * from test4"); // 4. 쿼리 실행
			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				System.out.println("id : " + id + ", password : " + password);  // 5. 쿼리 실행 결과 사용
			}
			
			// ----------------------------------------------------------	
			
			sql = "drop table test4";
			stmt.executeUpdate(sql);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (!commit)con.rollback();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();            // 6. Statement 종료
				if (con != null)
					con.close();             // 7. 데이터 베이스 커넥션 종료
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			}

	}

}
