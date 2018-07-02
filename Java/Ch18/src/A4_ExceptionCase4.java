//
// 둘 이상의 예외처리 방법 1: 정상적인 종료로 유도
//  
// try { 
// 관찰영역 (오류검사가 필요한 영역) 
// }
// catch(ArithmeticException e) {
//				e.getMessage();
//			}
//			catch(InputMismatchException e) {
//				e.getMessage();
//			}* 두개 이상의 오류를 한 번에 처리 할때
// }


import java.util.InputMismatchException;
import java.util.Scanner;

public class A4_ExceptionCase4 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
			
			try{
				System.out.print("a/b...a? ");
				int n1 = kb.nextInt();
				System.out.print("a/b...b? ");
				int n2 = kb.nextInt();	
				System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
			}
			catch(ArithmeticException e) {
				e.getMessage();
			}
			catch(InputMismatchException e) {
				e.getMessage();
			}
		System.out.println("Good bye~~!");
	}

}