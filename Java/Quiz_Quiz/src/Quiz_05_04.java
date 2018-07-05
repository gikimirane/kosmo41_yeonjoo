import java.util.Scanner;

// Quiz 05 04

// 두개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
// 단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
// 1 과 2 를 입력했다면 1 .... 20과10을 입력했다면 10 ....
// 위 프로그램을 작성해보자.

public class Quiz_05_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		int result2 = 0;
		
		System.out.println("두 개의 정수를 입력하세요");
		
		for(int i=0; i<2; i++) {
		
			num1 = s.nextInt();
			num2 = s.nextInt();
		
			if(num1 >= num2) {	
				result = num1 - num2;
		    		System.out.println(num1 + " - " + num2 + " = " + result);
		    		break;
			}else if(num1 < num2) {
				result2 = num2 - num1; 
					System.out.println(num2 + " - " + num1 + " = " + result2);
					break;
			}
		
		}
	
	}

}
