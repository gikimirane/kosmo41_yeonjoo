import java.util.Scanner;

// Quiz 05 11

// 정수 하나를 입력받은후 그 수의
// 팩토리얼 함수의 결과를 출력하는 프로그램을 while문을 이용하여 구현하시오.
// 출력예) 입력정수 : 5
// 5*4*3*2*1 = 120

public class Quiz_05_11 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		int user = 0;
		int result = 1;
		
		System.out.println("정수 하나를 입력하세요");
		

		user = s.nextInt();
		
		while(user>=2){			
					result = result * user;
					
					System.out.print(user);	
					System.out.print(" x ");
					user--;	
					
		}System.out.println("1 = " + result);
		
		
	}

}
