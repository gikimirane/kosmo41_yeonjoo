import java.util.Random;

//
// 난수 생성의 예
//

public class F1_SeedSetRandom {

	public static void main(String[] args) {
		
		Random rand = new Random(); //시드 값을 지정 X > 실행할때마다 다른 결과를 보임
		
		for(int i = 0; i <7; i++)
			System.out.println(rand.nextInt(1000));
	}

}
