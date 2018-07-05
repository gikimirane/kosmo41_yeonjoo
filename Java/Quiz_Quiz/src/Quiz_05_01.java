import java.util.Scanner;

// Quiz 05 01

// 사용자로부터 계속해서 정수를 입력받는다.
// 단 '0을 입력받게되면' 
// 기존에 입력받은 모든 정수를 더한후 결과를 출력하는 프로그램을 작성하시오.

public class Quiz_05_01 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int user = 0;
		int sum = 0;
		System.out.println("정수를 입력하세요");
	
// do ~ While 문 활용
		
 		do {
			user =s.nextInt();
			sum = sum + user;
		} while(user != 0);
		System.out.println("입력하신 정수의 합은 : " + sum );
		
// while문 활용
		
//		while(true) {
//			user = s.nextInt();
//			sum = sum + user;
//			if(user == 0 ) {
//				System.out.println("입력하신 정수의 합은 : " + sum );
//				break;
//			}
		
		
	}

}
