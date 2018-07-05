import java.util.Scanner;

// Quiz 03 02

// 하나의 정수를 입력받아서 
// 그 수의 제곱을 출력하는 프로그램을 작성하라. (5를 입력받으면 25가 출력되어야 함)

public class Quiz_03_02 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int num = 0;
		
		System.out.println("한 개의 정수를 입력하세요");
		
		num =s.nextInt();
		
		System.out.println("입력하신 정수에 대한 제곱의 수: " + (num*num));

	}

}
