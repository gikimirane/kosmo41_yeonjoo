//Quiz 05 13

// 중첩 for문을 이용하여 구구단 전체를 출력하는 프로그램을 작성하시오.
// 단 가로형, 세로형 둘다 만들어야함.

public class Quiz_05_13 {

	public static void main(String[] args) {

		System.out.println("가로형 구구단 출력");

		for (int a = 1; a <= 9; a++) {
			for (int b = 2; b <= 9; b++) {

				System.out.print(b + " * " + a + " = " + (b * a) + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("세로형 구구단 출력");
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {

				System.out.print(i + " * " + j + " = " + (i * j) + "\t");

			}
			System.out.println("");
		}
	}

}
