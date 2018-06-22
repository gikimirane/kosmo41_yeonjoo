import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요.");
		int InputNum1 = s.nextInt();
		
		System.out.println("두번째 숫자를 입력하세요.");
		int InputNum2 = s.nextInt();
		
		int result = 0;	
	
		if(InputNum1 > InputNum2) {
			result = InputNum1 - InputNum2;
		}
		else {
			result = InputNum2 - InputNum1;
		}	

	}

}
