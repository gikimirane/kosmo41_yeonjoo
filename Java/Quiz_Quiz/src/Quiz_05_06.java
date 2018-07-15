import java.util.Scanner;

// Quiz 05 06

// 사용자로부터 정수 하나를 입력받은 후 그 수에 해당하는 구구단을 역순으로 출력하시오.	

public class Quiz_05_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.println("정수를 한 개를 입력하세요");
		
		int user = 0;
		
		user = s.nextInt();
		
		for(int i = 9; i <= 2; i--) 
			{
				System.out.println(user + "x" + i + "=" + (user*i));
			}
		
	}
}
