
public class Quiz_13_10 {

	public static void main(String[] args) {
		
		int [][] arr1 = new int [4][4];
		int [][] arr2 = new int [4][4];
		
		int num = 1;
		
		int a = 0;
		int b = 0;
		
		// 1번째 
		
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{
				arr1[a][b] = num;
				num++;	
			}
		}
	
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{	
				System.out.printf("%3d",arr1[a][b]," ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
	// 2번째 
		
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{
				arr2[b][a] = arr1[3-b][a];
			}
		}
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{	
				System.out.printf("%3d",arr2[b][a]," ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		// 3번째 
		
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{
				arr2[a][b] = num-1;
				num--;
			}
		}
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{	
				System.out.printf("%3d",arr2[a][b]," ");
			}
			System.out.println();
		}
		System.out.println("-------------");

		// 4번째 
		
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{
				arr2[a][b] = arr1[b][3-a];
			}
		}
		for(a = 0; a <= 3; a++)
		{
			for(b = 0; b <= 3; b++)
			{	
				System.out.printf("%3d",arr2[a][b]," ");
			}
			System.out.println();
		}
		System.out.println("-------------");	
		
}
}
