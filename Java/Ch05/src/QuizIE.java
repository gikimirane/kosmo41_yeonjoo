import java.util.Scanner;

	public class QuizIE {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			int rv = 0;
			int sum = 0;
			int num = 0;
			
			System.out.println("���Ͻô� ���ڸ� �Է��ϼ���");
			
			 do {
				num = s.nextInt();
				sum = sum+num;
			} while(num != 0);
		
			System.out.println("�Է��Ͻ� ��� ������ ���� " + sum + " �Դϴ�."); 
		}

	}
	