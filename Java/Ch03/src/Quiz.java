import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("'1번째' 숫자를 입력하세요");
		
		int num1 = s.nextInt();
		
		System.out.println("'2번째' 숫자를 입력하세요");
		
		int num2 = s.nextInt();
		
		System.out.println("입력하신 숫자에 대한 사칙연산 결과 입니다.");
		
		System.out.println("-------------------------------------------");
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		
		System.out.println("-------------------------------------------");
		
	}

}
