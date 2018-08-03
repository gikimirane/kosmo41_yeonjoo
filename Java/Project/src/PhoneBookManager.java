import java.io.*;
import java.sql.*;
import java.util.*;

class PhoneBookManager {

	private final File dataFile = new File("PhoneBook.dat");
	HashSet<PhoneInfo> infoSt = new HashSet<PhoneInfo>();

	static PhoneBookManager inst = null;

	public static PhoneBookManager createManagerInst() {
		if (inst == null)
			inst = new PhoneBookManager();

		return inst;
	}

	private PhoneBookManager() {
		readFromFile();
	}

	private PhoneInfo readFriendInfo() {

		System.out.print("[ 이    름 ] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[ 전화번호 ] : ");
		String phone = MenuV.keyboard.nextLine();

		return new PhoneInfo(name, phone);

	}

	private PhoneInfo readUnivInfo() {

		System.out.print("[ 이    름 ] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[ 전화번호 ] : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("[ 전    공 ] : ");
		String major = MenuV.keyboard.nextLine();
		System.out.print("[ 학    년 ] : ");
		int year = MenuV.keyboard.nextInt();
		MenuV.keyboard.nextLine();

		return new PhoneUnivInfo(name, phone, major, year);

	}

	private PhoneInfo readCompanyInfo() {

		System.out.print("[ 이    름 ] : ");
		String name = MenuV.keyboard.nextLine();
		System.out.print("[ 전화번호 ] : ");
		String phone = MenuV.keyboard.nextLine();
		System.out.print("[ 회 사 명 ] : ");
		String company = MenuV.keyboard.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	public void inputdata() throws MenuChoiceException, SQLException {

		PhoneInfo info = null;
		
		
			System.out.println("[ 연락처 입력]");
			System.out.println("[1] 일반 | [2] 대학 | [3] 회사 ");
			System.out.print("[ 선택 값 입력 ] : ");
			
			int choice = MenuV.keyboard.nextInt();
			MenuV.keyboard.nextLine();

			Connection con = ConnectionPool.getConnection();
			PreparedStatement pstmt = null;

			String sql = " ";

		try {
			if (choice < INPUT_SELECT.NOR || choice > INPUT_SELECT.COM)
				throw new MenuChoiceException(choice);

			switch (choice) {
			case INPUT_SELECT.NOR:
				info = readFriendInfo();

				sql = "insert into contact41(" + "name,phone) " + "values(?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info.name);
				pstmt.setString(2, info.phoneNum);

				int updateCount = pstmt.executeUpdate();
			//	System.out.println("insert Count : " + updateCount);
				break;
				
			case INPUT_SELECT.UNIV:
				
				PhoneUnivInfo info1 = (PhoneUnivInfo) readUnivInfo();

				sql = "insert into contact41(" + "name,phone,major,year) " + "values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info1.name);
				pstmt.setString(2, info1.phoneNum);
				pstmt.setString(3, info1.major);
				pstmt.setInt(4, info1.year);

				updateCount = pstmt.executeUpdate();
		//		System.out.println("insert Count : " + updateCount);
				break;
				
			case INPUT_SELECT.COM:
				PhoneCompanyInfo info2 = (PhoneCompanyInfo) readCompanyInfo();

				sql = "insert into contact41(" + "name,phone,company) " + "values(?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, info2.name);
				pstmt.setString(2, info2.phoneNum);
				pstmt.setString(3, info2.company);

				updateCount = pstmt.executeUpdate();
		//		System.out.println("insert Count : " + updateCount);
				break;
		}

		System.out.println("[ 연락처 입력 완료 ] ");

		} catch (MenuChoiceException e) {
			e.showWrongChoice();
			System.out.println("[메뉴 선택 재진행] ");

		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
			
		}
		
		// 동명이인 잡기
		
		// boolean isAdded = infoSt.add(info);
		// if (isAdded == true)
		// System.out.println("[ 데이터 입력이 완료 ] ");
		// else
		// System.out.println("[ 이미 저장된 데이터입니다. ] ");

	}

	public void searchData() throws MenuChoiceException, SQLException {

		System.out.println("[ 연락처 검색 ] ");
		System.out.print("[ 검색할 이름 입력 ] : ");

		String name = MenuV.keyboard.nextLine();

		PhoneInfo info = null;

		Connection con = ConnectionPool.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "select * from contact41 where name like '%" + name + "%'";
		//	System.out.println("name:["+ name + "]");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(" ");
				System.out.println("[ 연락처 검색 결과 출력 ] ");
				System.out.println(" ");
				System.out.println("[ 이    름 ] : " + rs.getString(1));
				System.out.println("[ 전화번호 ] :  " + rs.getString(2));
				System.out.println("[ 전    공 ] :  " + rs.getString(3));
				System.out.println("[ 학    년 ] :  " + rs.getString(4));
				System.out.println("[ 회 사 명 ] :  " + rs.getString(5));
			
			}System.out.println(" "); 
			 System.out.println("[ 해당하는 데이터 없음 ] ");
			return;
			
		} catch (Exception e) {
			System.out.println(e + "[ 오류발생 ]");
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
			
		}


	}

	public void delData() throws MenuChoiceException, SQLException {

		System.out.println("[ 연락처 삭제 ] ");
		System.out.print(" [삭제할 이름 입력 ] : ");

		String name = MenuV.keyboard.nextLine();

		PhoneInfo info = null;

		Connection con = ConnectionPool.getConnection();
		PreparedStatement pstmt = null;

	try {
		
			String sql = "delete from contact41 where name like '%" + name + "%'";
			pstmt = con.prepareStatement(sql);
			int del = pstmt.executeUpdate(); // 실행 > 삭제

			if (del > 0) {
			System.out.println("[ 연락처 삭제 완료 ] ");
			} else {
			System.out.println("[ 일치하는 데이터가 없음 (삭제 실패) ] ");
			
			} return;

			} catch (Exception e) {
			System.out.println(e + "[ 오류발생 ]");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
			
		}

	}

	public void allData() throws MenuChoiceException, SQLException {

		PhoneInfo info = null;

		Connection con = ConnectionPool.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from contact41";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println(" ");
			System.out.println("[ 전체연락처보기 ] ");
			System.out.println(" ");
			
			while (rs.next()) {
				
				String name = rs.getString(1);
				String num = rs.getString(2);				
				System.out.println("[이   름] : " + name + ", [전화번호] : " + num);
			//	System.out.println(rs.getString(1));

			}

		} catch (Exception e) {
			System.out.println(e + "[ 오류발생 ]");
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException sqle) {}
			
		}
	}

	private PhoneInfo search(String name) {

		Iterator<PhoneInfo> itr = infoSt.iterator();
		while (itr.hasNext()) {
			PhoneInfo curInfo = itr.next();
			if (name.compareTo(curInfo.name) == 0)
				return curInfo;
		}

		return null;
	}

	public void storeToFile() {
		try {
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);

			Iterator<PhoneInfo> itr = infoSt.iterator();

			while (itr.hasNext())
				out.writeObject(itr.next());

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		if (dataFile.exists() == false)
			return;
		try {
			FileInputStream file = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(file);

			while (true) {
				PhoneInfo info = (PhoneInfo) in.readObject();
				if (info == null)
					break;
				infoSt.add(info);

			}
			in.close();

		} catch (IOException e) {
			return;
		} catch (ClassNotFoundException e) {
			return;
		}
	}
}
