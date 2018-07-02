//
// 예외상황 1 : 수학적 오류가 발생했을 경우
//    ㄴ ArithmeticException: * 0으로 나눴을 경우 등등 ..

import java.util.Scanner;

public class A1_ExceptionCase1 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("a/b...a? ");
		int n1 = kb.nextInt();
		
		System.out.print("a/b...b? ");
		int n2 = kb.nextInt();
		
		System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
		System.out.println("Good bye~~!");

	}

}