import java.util.Scanner;

	public class QuizE {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("�� ���� ���ڸ� �Է��ϼ���.");
			
			int num = s.nextInt();
			
			System.out.println("����� �Է��� ���ڴ� " + num + " �Դϴ�.");
			
			System.out.println("----------------------------");
			
			System.out.println("����� �Է��� ������ ������ ");
			
			int rv = num*num;
			
			System.out.println(rv + " �Դϴ�.");
			
			System.out.println("----------------------------");
		}

	}
