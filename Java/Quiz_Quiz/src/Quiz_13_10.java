
public class Quiz_13_10 {

	public static void main(String[] args) {
		
		int [][] arr = new int [5][5];
		
		int num = 1;
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				arr[i][j] = num;
				num++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println("------------");	
	
	 /*	for(int j = 0; j < 4; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				arr[j][i] = num - 1;
				num--;
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
			
		}
		System.out.println("------------");	*/
	
		
		int num2 = 17;
		
		for(int j = 0; j < 4; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				arr[i][j] = num2 - 1;
				num2--;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println("------------");	
		
		int num3 = 5;
		
		for(int j = 3; j >= 0; j--)
		{
			for(int i = 3; i >= 0; i--)
			{
				//arr[i][j] = num3;
				arr[j][i] = num3 - 1;
				num3--;
				System.out.print((arr[j][i] + 4) + " ");
			}
			System.out.println();
			
		}
		System.out.println("------------");	
	
	
			
		
		
	

}
}
