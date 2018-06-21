import java.util.Scanner;

	public class QuizIE {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			int rv = 0;
			int sum = 0;
			int num = 0;
			
			System.out.println("원하시는 숫자를 입력하세요");
			
			 do {
				num = s.nextInt();
				sum = sum+num;
			} while(num != 0);
		
			System.out.println("입력하신 모든 숫자의 합은 " + sum + " 입니다."); 
		}

	}
	