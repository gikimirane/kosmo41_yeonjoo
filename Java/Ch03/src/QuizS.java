import java.util.Scanner;

	public class QuizS {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("�� ���� ���ڸ� �Է��ϼ���.");
			
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			
			System.out.println("����� �Է��� ���ڴ� "+ num1 + "," + num2 + "�Դϴ�.");
			
			System.out.println("-----------------------------------------");
			
			System.out.println(num1 + " ������ " + num2 + " �� ���� " + (num1 / num2) + "�Դϴ�.");
			System.out.println(num1 + " ������ " + num2 + " �� �������� " + (num1 % num2) + "�Դϴ�.");
			
			System.out.println("-----------------------------------------");
			
		}

	}
	