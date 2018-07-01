
public class Quiz_13_7 {

	public static void main(String[] args) 
	{
		
		int [][] arr = new int [2][4];
		int num = 1;
		
		for(int i = 0; i < 2; i++)
		{
			for(int j=0; j < 4; j++)
			{
				arr[i][j] = num;
				num++;
			}
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(int j=0; j < 4; j++)
			{ 
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println("-------");
		
		int [][] arr2 = new int [4][2];
		int num2 = 1;
		
		for(int i = 0; i < 4; i++)
		{
			for(int j=0; j < 2; j++)
			{
				arr2[i][j] = num2;
			}
		}
		
		for(int i = 0; i < 4; i++)
		{
			for(int j=0; j < 2; j++)
			{ 
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
		}
	}

}









 // 쌤 답안

/* 

int arr1[2][4] = { {1,2,3,4},{5,6,7,8} };

for(int i = 0; i < 2; i++)
{
	for(int j=0; j < 4; j++)
	{ 
		System.out.print(arr1[i][j] + " ");
	}
	System.out.println();

} */
