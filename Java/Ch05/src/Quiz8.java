import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		int Inputnum = 0;
		int sum = 0;
		int count = 0;
		
		System.out.println("숫자 5 개를 입력하세요");

		do { 
		       Inputnum = s.nextInt();
		       sum = sum + Inputnum;
		       
		       if (Inputnum == 0)
		       {
		         System.out.println("1 이상의 숫자를 입력하세요");
		         continue;
		       }
		       count++;
		} while(count < 5);

		System.out.println("입력하신 정수의 합은" + sum);

	
				
	}
			
}

