import java.util.Scanner;

public class Quiz6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("숫자 한 개를 입력하세요");
		
	    int num1 = s.nextInt();
			
		for (int j=9; j>=2; j--) 
			{ 
			System.out.println(num1 + " x " + j + " = " + (num1 * j));		
			}
			
		}

}
