//
// 상수 : 변수에 값을 딱 한번만 할당 할수 있고 변경이 불가능하다
//

public class Constants {

	public static void main(String[] args) {
		final int MAX_SIZE = 100;
		final char CONST_CHAR = '상';
		
		final int CONST_ASSIGNED;
		CONST_ASSIGNED = 12;       //할당하지 않았던 상수의 값을 할당 
		
		System.out.println("상수1 : " + MAX_SIZE);
		System.out.println("상수2 : " + CONST_CHAR);
		System.out.println("상수3 : " + CONST_ASSIGNED);

	}

}
