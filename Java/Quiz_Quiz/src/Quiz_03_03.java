import java.util.Scanner;

// Quiz 03 03

// 두개의 정수를 입력받아서 나누기의 몫과 나머지를 구해보자

// ex) 두개의 정수를 입력하세요 
// 두개의 정수 : 25 / 4
// 25 나누기 4 의 몫은 6 입니다.
// 25 나누기 4 의 나머지는 1 입니다.

public class Quiz_03_03 {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		
		System.out.println("첫 번째 정수를 입력하세요");
		
		num1 = s.nextInt();
		
		System.out.println("두 번째 정수를 입력하세요");
		
		num2 = s.nextInt();
		
		System.out.println("입력하신 두 개의 정수는 " + num1 + " / " + num2);
		System.out.println(num1 + "나누기" + num2 + "의 몫은" + (num1/num2) + "입니다.");
		System.out.println(num1 + "나누기" + num2 + "의 나머지는 " + (num1%num2) + "입니다.");

	}

}
