import java.util.Random;
import java.util.Scanner;

public class HighLow {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		
		while(true) 
		{	
			System.out.println("게임을 시작하지 후후후");
			System.out.println("0 ~ 100 중에서 내가 정한 숫자는 몇일까?");
			
			int com = rand.nextInt(101);
			// System.out.println("com : " + com ); 컴퓨터 정답을 보면서 검증
			
			for(int i=0; i<6; i++) 
			{
				int user = s.nextInt();
				
				if( com < user ) System.out.println(user + " 노노노~ 내가 정한 숫자보다 크다구 ~");
				if( com > user ) System.out.println(user + " 노노노~ 내가 정한 숫자보다 작다구 ~");

				if( com == user ) { 
					System.out.println(user + " 오오 대단하군 정답이야 ! ");
					break;
				}
				
				if(i < 5) 
					System.out.println("기회는 " + (6 - i - 1) + "번 밖에 남지 않았어");
				else
					System.out.println("내가 준 기회를 모두 써버렸군..");
		     }
			
			System.out.println("한 게임 더 도전하겠나?? (y/n) ");
			String str = s.next();
			if (!str.equalsIgnoreCase("y")) {
				System.out.println("좋은 승부였다. 다음에 또 보자구 ! ");
				break;
			}
				
	     }
		
	}

}
