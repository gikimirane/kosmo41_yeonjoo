
public class Quiz_13_9 {

	public static void main(String[] args) 
	{

		int arr1[] = {210,19,72,129,34};
		
		for (int i = 0; i <2; i++) 
		{
			
			int a = 210;
			int b = 19;
			int c = 72;
			int d = 129;
			int e = 34;
			
			if (a < b) 
			{
				System.out.println(arr1[a]);
			    break;
			}else if (a > b)
			{
				continue;
			}
			if (b < c) 
			{
				System.out.println(arr1[b]);
			    break;
			}else if (b > c)
			{
				continue;
			}
			if (c < d) 
			{
				System.out.println(arr1[c]);
			    break;
			}else if (c > d)
			{
				continue;
			}
			if (d < e) 
			{
				System.out.println(arr1[d]);
			    break;
			}else if (d > e)
			{
				continue;
			}
			if (e < a) 
			{
				System.out.println(arr1[e]);
			    break;
			}else if (e > a)
			{
				continue;
			}

		}

	}
}
