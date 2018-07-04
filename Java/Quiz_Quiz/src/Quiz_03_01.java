import java.util.Scanner;

// Quiz 03 01

// 사용자로부터 두개의 정수를 입력받아서 
// 사칙연산에 대한 결과를 출력하는 프로그램을 작성하라.

public class Quiz_03_01 {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		
		int InputNum1 = 0;
		int InputNum2 = 0;
		
		System.out.println("첫번째 정수를 입력하세요");
		
		InputNum1 = s.nextInt();
		
		System.out.println("두번째 정수를 입력하세요");
		
		InputNum2 = s.nextInt();
		
		System.out.println("입력하신 두 정수에 대한 사칙연산 결과 입니다.");
		
		System.out.println(InputNum1 + "+" + InputNum2 + " = " + (InputNum1 + InputNum2));
		System.out.println(InputNum1 + "-" + InputNum2 + " = " + (InputNum1 - InputNum2));
		System.out.println(InputNum1 + "x" + InputNum2 + " = " + (InputNum1 * InputNum2));
		System.out.println(InputNum1 + "/" + InputNum2 + " = " + (InputNum1 / InputNum2));

	}

}
