
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
		
	

}
}
