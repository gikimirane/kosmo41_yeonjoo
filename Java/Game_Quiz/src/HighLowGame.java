import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class HighLowGame {

	public static void main(String[] args) 
	{
		int com;
		int user;
		
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("게임을 시작하지 후후");
		System.out.println("0~100 중에서 내가 생각한 숫자는 몇일까?");
	
		while(true) 
		{		
			com = rand.nextInt(101);
			System.out.println("com : " + com ); //컴퓨터 정답을 보면서 검증
		
			int count = 5;		
			for(int i=0; i<6; i++) 
			{
				 
				user = s.nextInt();
			
				if(com > user) 
				{
					System.out.println("노노노~ 내가 생각한 숫자보다 작아");	
				}else if(com < user) 
				{
					System.out.println("노노노~ 내가 생각한 숫자보다 크다구");
				
				}else if(com == user) 
				{
					System.out.println(user + " 오~ 이런~ 정답을 맞춰 버렸군 ");
					break;
				}
			 }	
			
			if(count != 0) 
					{
						System.out.println("이제 기회는 " + count + "번 남았어 ");
						count--;
					} else if (count == 0) 
					{
						System.out.println("이제 기회가 없어 재도전 할건가? (y/n)");	
						
						String chan = s.nextLine();
						if(chan.equals("y"))
						{
							System.out.println("다음에 또 보지");
						    break;
						}else if(chan.equals("n"))
						{
							continue;
						}
					}
						
			}
				
				
	}
}






