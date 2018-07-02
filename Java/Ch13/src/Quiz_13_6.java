class Quiz_13_6 {
	
	public static void main(String[] args) 
	{
		int [][] arr = new int [3][9];
		
		for(int i = 2; i < 5; i++)
		{
			for(int j=1; j < 10; j++)
			{
				arr[i-2][j-1] = i * j;
			}
		}
		
		for(int i = 0; i < 3; i++)
		{
			for(int j=0; j < 9; j++)
			{ 
				System.out.print((i+2) + " x " + (j+1) + " = " + arr[i][j]);
			}
			System.out.println();
			
		}
		System.out.println("-------");
		
	}

}
					
					
					
		
				
				


