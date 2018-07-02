//
// 예외상황 처리: 수학적 오류가 발생 후 > 정상적인 종료로 유도
//  
// try { 
// 관찰영역 (오류검사가 필요한 영역) 
// }
// Catch(ArithmeticException) { 
//       오류처리 영역
// }


import java.util.Scanner;

public class A3_ExceptionCase3 {

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
				System.out.println(e.getMessage());
			}
		System.out.println("Good bye~~!");
	}

}


