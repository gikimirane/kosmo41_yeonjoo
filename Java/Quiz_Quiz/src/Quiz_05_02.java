import java.util.Scanner;

// Quiz 05 02

// 사용자로부터 다음 순서대로 정수를 입력받은 후 평균을 구하여 출력하시오.
// 1. 몇개의 정수를 입력할 지 사용자로부터 입력받는다
// 2. 입력받은 숫자만큼 정수를 입력받는다.
//    (조건1에서 3이라고 입력했다면 3개의 정수를 입력받아야 한다)
// 3. 입력받은 숫자들의 평균값을 구하여 출력한다. 평균값은 소수점 이하까지 계산해야 한다.


public class Quiz_05_02 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int count = 0;
		int user = 0;
		double sum = 0;
		double result = 0;
		
		System.out.println("몇 개의 정수를 입력하시겠습니까?");
		
		count = s.nextInt();
	
		System.out.println("정수를 입력하세요");
		
		for(int i=0; i<count; i++)
		{ 
			user = s.nextInt();
			sum = sum + user;
			result = sum / count;
		}
		System.out.println("입력하신 정수의 평균은 " + result + "입니다.");
	}

}
