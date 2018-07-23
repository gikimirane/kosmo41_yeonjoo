import java.util.Scanner;

public class Quiz_05_1 {

	public static void main(String[] args) {
		
		
		int inputnum = 0;
		int user = 0;
		
		Scanner s = new Scanner (System.in);
			
		System.out.println("정수를 입력하세요");
		
			
		 do { 
				user = s.nextInt();
				inputnum = user + inputnum; 
				
			}while(user != 0);
				 
		 System.out.println("입력하신 정수의 합은" + inputnum);

	}

}
