import java.util.Random;

//
//난수 생성의 예
//

public class F3_PseudoRandom {

	public static void main(String[] args) {
		
		Random rand = new Random(12); //시드 값을 고정 O > 실행 했을 때 동일 결과가 나옴
		
		for(int i = 0; i <7; i++)
			System.out.println(rand.nextInt(1000));

	}

}
