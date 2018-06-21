import java.util.Scanner;

	public class QuizE {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("한 개의 숫자를 입력하세요.");
			
			int num = s.nextInt();
			
			System.out.println("당신이 입력한 숫자는 " + num + " 입니다.");
			
			System.out.println("----------------------------");
			
			System.out.println("당신이 입력한 숫자의 제곱은 ");
			
			int rv = num*num;
			
			System.out.println(rv + " 입니다.");
			
			System.out.println("----------------------------");
		}

	}
