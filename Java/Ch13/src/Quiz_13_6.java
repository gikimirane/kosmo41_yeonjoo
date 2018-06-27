class Quiz_13_6 {
	
	public static void main(String[] args) 
	{
		int [][] arr2 = new int [3][9];
		
		int i = 0;
		int j = arr2.length-2;
		int num = 0;
				
		for(i = 2; i < 4; i++)
		{		
			for(j = 1; j < 9; j++)
				{
				arr2[i][j] = num;
				num++;
				}
			
		}
		
		for(i = 2; i < 4; i++)
		{		
			for(j = 1; j < 9; j++)
				{
					System.out.print(arr2[i][j] + "\t");
				}
				System.out.println();
			}
		}
		
	}


					
					
					
		
				
				


