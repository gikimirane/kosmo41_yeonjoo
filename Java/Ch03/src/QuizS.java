import java.util.Scanner;

	public class QuizS {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("두 개의 정수를 입력하세요");
			
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			
			System.out.println("입력하시는 숫자는 "+ num1 + "," + num2 + "입니다");
			
			System.out.println("-----------------------------------------");
			
			System.out.println(num1 + " 나누기 " + num2 + " 의 몫은 " + (num1 / num2) + "입니다");
			System.out.println(num1 + " 나누기 " + num2 + " 의 나머지는 " + (num1 % num2) + "입니다");
			
			System.out.println("-----------------------------------------");
			
		}

	}
	