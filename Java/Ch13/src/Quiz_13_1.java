import java.util.Scanner;

public class Quiz_13_1 
{

	public static void main(String[] args) 
	{
		
		int[] num = new int[5];
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("5 개의 숫자를 입력하세요 (100미만의 숫자)");
		for(int i = 0; i < 5; i++)
		{
			num[i] = s.nextInt();
		}

		int nMax = 0; //최대값 보관
		int nMin = 1000; // 최소값 보관
		int sum = 0;	
		
		for(int i=0; i<5; i++) 
		{	
			if( nMax < num[i] ) 
			{  
				nMax = num[i];	
			}
			if( nMin > num[i] ) 
			{  
				nMin = num[i];	
			}
		    
		    sum = sum + num[i];
		 }
		
		System.out.println("입력하신 수의 최대값 : " + nMax); 
		System.out.println("입력하신 수의 최소값 : " + nMin); 
		System.out.println("입력하신 수의 합 : " + sum );		

	}

}
