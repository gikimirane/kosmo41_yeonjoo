import java.util.Arrays;

/*
 * 스트림의 예제 (축약형)
 */

class A2_MyFirstStream2 {

	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5};
		
		int sum = Arrays.stream(ar) //스트림 생성
						.filter(n -> n%2 == 1) //filter 통과,
						.sum(); // sum 통과 결과 반환
		
		System.out.println(sum); //결과 출력

	}

}
