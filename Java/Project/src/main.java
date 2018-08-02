import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

// 메뉴선택 클래스

class MenuV {

	public static Scanner keyboard = new Scanner(System.in);

	public static void showMenu() {
		
		System.out.println("");
		System.out.println("[메 뉴 선 택] ");
		System.out.println("[1] 데이터입력 | [2] 데이터검색 | [3] 데이터삭제 | [4] 전체이름출력 | [5] 종료");
		System.out.println("");
		System.out.println("[선택값 입력] : ");

	}
}


// 메인

class main {
	
	public static void main(String[] args) throws SQLException {

		PhoneBookManager manager = PhoneBookManager.createManagerInst();
	
		Connection con = ConnectionPool.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "create table project(name varchar(20)," +
  					 	 "                     phone varchar(40),"+
  					  	 "                     major varchar(20),"+
  					 	 "                     year varchar(5),"+
  					 	 "                     company varchar(20))";
			
			con = ConnectionPool.getConnection();
			pstmt = con.prepareStatement(sql);
			int updateCount = pstmt.executeUpdate();
			System.out.println("createCount : " + updateCount);
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
			
		}
		
		int choice;

		while (true) {

			try {
				
				MenuV.showMenu(); 
				choice = MenuV.keyboard.nextInt();
				MenuV.keyboard.nextLine();

				if (choice < INIT_MENU.INPUT || choice > INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);
				
				switch (choice) {
				case INIT_MENU.INPUT:
					manager.inputdata();
					break;
				case INIT_MENU.SEARCH:
					manager.searchData();
					break;
				case INIT_MENU.DEL:
					manager.delData();
					break;
				case INIT_MENU.ALL:
					manager.allData();
					break;
				case INIT_MENU.EXIT:
					System.out.println("[프로그램 종료] ");
					System.out.println("[ 사 요 나 라 ] ");
					return;
				}

			}catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("[메뉴 선택 재진행] ");

			}

		}

	}
}