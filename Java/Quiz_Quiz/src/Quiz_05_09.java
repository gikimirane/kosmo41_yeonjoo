//Quiz 05 09

//1부터 100까지 정수중에서 짝수의 합을 구하라. 단 do~while문을 이용하라

public class Quiz_05_09 {

	public static void main(String[] args) {

		int i = 0;
		int sum = 0;
	
		do {
			i++;
			if(i%2 == 0) {
				sum = sum + i;
			}
		}while(i <= 100);
		
		System.out.println("1 부터 100 까지 정수중에서 짝수의 합은 : " + sum );
	}

}
