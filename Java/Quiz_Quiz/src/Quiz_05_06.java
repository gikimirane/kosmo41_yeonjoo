import java.util.Scanner;

// Quiz 05 06

// 사용자로부터 정수 하나를 입력받은 후 그 수에 해당하는 구구단을 역순으로 출력하시오.	

public class Quiz_05_06 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
			int user = 0;
		
		System.out.println("정수 하나를 입력하세요");
		
			user = s.nextInt();
			
			System.out.println("입력하신 정수에 해당하는 구구단 (역순)");
			
			//포카리 작품
			
			for(int i = 9; i>=1; i--) {
				System.out.println(user + " * " + i+" = " +(user*i));
			}

	}
}
/*
for(int i=9; i>=2; i--) {
for(int j=9; j>=1; j--) {
	if(user == i) {
		
		System.out.println(i + " x " + j + " = " + (i*j));
}
}
}
*/