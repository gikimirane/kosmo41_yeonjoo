import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args)
	{
	
		Scanner s = new Scanner(System.in);

		int InputKor = 0, InputEng = 0, InputMath = 0;

		System.out.println("전과목 점수 입력 후 자신의 학점을 확인하세요");

		System.out.println("첫번째 국어 점수를 입력하세요");
		InputKor = s.nextInt();
		System.out.println("두번째 영어 점수를 입력하세요");
		InputEng = s.nextInt();
		System.out.println("세번째 수학 점수를 입력하세요");
		InputMath = s.nextInt();

		int sum = 0;
		sum = InputKor + InputKor + InputKor;

		int Aver = 0;
		Aver = sum / 3;

		if(Aver >= 90)
		System.out.println("평균은" + Aver + "이고 학점은 A 입니다." );
		else if(Aver >= 80)
		System.out.println("평균은" + + Aver + "이고 학점은 B 입니다." );
		else if(Aver >= 70)
		System.out.println("평균은" + + Aver + "이고 학점은 C 입니다." );
		else if(Aver >= 50)
		System.out.println("평균은" + + Aver + "이고 학점은 D 입니다." );
		else 
		System.out.println("평균은" + + Aver + "이고 학점은 F 입니다." );

	}

}
