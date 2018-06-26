import java.util.Scanner;

public class Quiz_13_4 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("10 개의 숫자를 입력하세요");
		
		int aaa = 0;
		int bbb = arr.length-1;
		
		for(int i = 0; i < 10; i++)
		{
			int num = s.nextInt();
			
			if( num % 2 != 0 )
			{
				arr[aaa] = num;
			    aaa++;
			}
			if( num % 2 == 0 )
			{
				arr[bbb] = num;
			    bbb--;
			}
				
		}
			
		for(int i = 0; i <arr.length ; i++) 
		{	
			System.out.print(arr[i] + " ");
		 }

	
	}

}
