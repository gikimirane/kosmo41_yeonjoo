//
// 예외상황 2 : 수치가 아닌 문자열을 입력했을 떄 발생하는 오류
//    ㄴ InputMismatchException

import java.util.Scanner;

public class A2_ExceptionCase2 {

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
