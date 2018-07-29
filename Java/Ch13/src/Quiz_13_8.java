import java.util.Scanner;

public class Quiz_13_8 {

	public static void main(String[] args) {

		int[][] array_1 = new int[4][4];

		Scanner s = new Scanner(System.in);

		System.out.println("국어점수를 입력하세요");

		int[] array_kor = new int[4];

		for (int i = 0; i < 3; i++) {
			array_kor[i] = s.nextInt();
		}

		System.out.println("영어점수를 입력하세요");

		int[] array_eng = new int[4];

		for (int i = 0; i < 3; i++) {
			array_eng[i] = s.nextInt();
		}

		System.out.println("수학점수를 입력하세요");

		int[] array_met = new int[4];

		for (int i = 0; i < 3; i++) {
			array_met[i] = s.nextInt();
		}

		System.out.println("국사점수를 입력하세요");

		int[] array_his = new int[4];

		for (int i = 0; i < 3; i++) {
			array_his[i] = s.nextInt();
		}
	
	}
}