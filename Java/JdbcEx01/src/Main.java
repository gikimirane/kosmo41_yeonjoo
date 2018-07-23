import java.sql.*;

// JDBC : 자바에서 데이터베이스와 관련 된 작업을 할 떄 사용하는 API

public class Main {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", 
					"tiger");
			Statement stmt = con.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("select * from employee");

			ResultSet rs = stmt.executeQuery(sb.toString());

			while (rs.next()) {
				System.out.print("eno : " + rs.getInt(1) + ", ");
				System.out.println("ename : " + rs.getString("ename"));
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}

	}

}
