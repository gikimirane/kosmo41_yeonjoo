import java.util.Scanner;

// Quiz 05 07

// 학생의 교내 전체 평균점수에 대한 학점을 출력하는 프로그램을 작성하라.
// 실행시 국어, 영어, 수학의 점수를 차례로 입력받은 후 평균을 구한 후
// 90점이상 A, 80점이상 B, 70점이상 C, 50점이상 D, 그 미만이면 F를 출력한다.

public class Quiz_05_07 {

	public static void main(String[] args) {

		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int avg = 0;
		
		Scanner k = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
	
		num1 = k.nextInt();
		
		Scanner e = new Scanner(System.in);
		System.out.println("영어 점수를 입력하세요");
	
		num2 = e.nextInt();
		
		Scanner m = new Scanner(System.in);
		System.out.println("수학 점수를 입력하세요");
	
		num3 = m.nextInt();
		
		avg = (num1 + num2 + num3) / 3;
		
		if(avg>=90) {
			System.out.println("당신의 평균은" + avg + "이고, 학점은 A 입니다.");
			
		}else if(avg>=80) {
			System.out.println("당신의 평균은" + avg + "이고, 학점은 B 입니다.");
		}else if(avg>=70) {
			System.out.println("당신의 평균은" + avg + "이고, 학점은 C 입니다.");
		}else if(avg>=50) {
			System.out.println("당신의 평균은" + avg + "이고, 학점은 D 입니다.");
		}else if(avg<=49) {
			System.out.println("당신의 평균은" + avg + "이고, 학점은 F 입니다.");
			
					
	}

}

}
