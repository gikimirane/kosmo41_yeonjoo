public class Quiz14 
{

	public static void main(String[] args) 
	{			
		for(int i=0; i<10; i++)
		{
			for (int j=0; j<10; j++)				
			{
				if (((i * 10 + j) + (j * 10 + 1)) == 99 && i != j )
				{	
			
					System.out.println(i + " " + j);
					System.out.println(j + " " + i);
					System.out.println("---");
				}
			} 
    	} 
	}
} 	
		
		/* for(int j=0; j<10; j++) 
			{
		    	for(int i=9; i>=0; i--) 
		    	{
		    	
		    		if(((j*10) + i) + (j + (i*10)) == 99 && j != i);
		    		{
		    		
		    		System.out.println(j + " " + i);
		    		System.out.println(i + " " + j);
		    		System.out.println("---"); */
