import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		int Inputnum = 0;
		int sum = 0;
		int count = 0;
		
		System.out.println("���� 5 ���� �Է��ϼ���");

		do { 
		       Inputnum = s.nextInt();
		       sum = sum + Inputnum;
		       
		       if (Inputnum == 0)
		       {
		         System.out.println("1 �̻��� ���ڸ� �Է��ϼ���");
		         continue;
		       }
		       count++;
		} while(count < 5);

		System.out.println("�Է��Ͻ� ������ ����" + sum);

	
				
	}
			
}

