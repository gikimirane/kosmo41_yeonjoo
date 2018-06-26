import java.util.Scanner;

public class Quiz_13_3 {
	
	public static void main(String[] args) {
		
		int[] num = new int[10];
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("10 개의 숫자를 입력하세요");
		
		for(int i = 0; i < 10; i++)
		{
			num[i] = s.nextInt();
		}
		
		System.out.print("짝수출력 : "); 
		for(int i = 0; i < 10; i++) 
		{	
			if( num[i] % 2 == 0 )
			{
				System.out.print(num[i] + " "); 					  
			}
		
		 }
		System.out.println(); 
		System.out.print("홀수출력 : "); 
		for(int i = 0; i < 10; i++) 
		{	
			if( num[i] % 2 != 0 )
			{
				System.out.print(num[i] + " "); 					  
			}
		
		 }
			

	}

	}
