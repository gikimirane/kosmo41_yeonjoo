import java.util.StringTokenizer;

class Add {

	public static void main(String[] args) 
	{
		StringTokenizer v = new StringTokenizer("a:b:c", ":"); // 구분기호 " : "	
		StringTokenizer n = new StringTokenizer("1 2 3");  //구분기호 X *공백을 구분기호로 인식
		
		String s = v.nextToken();
		int sum = Integer.parseInt(n.nextToken());
		
		while (v.hasMoreTokens())
		{
			String str = v.nextToken();
			System.out.println(str);
			s = s + " + " + str;
			sum = sum + Integer.parseInt(n.nextToken());
					
			// s = s + " + " + (v.nextToken());
			// sum = sum + Integer.parseInt(n.nextToken()); 
		}
		 System.out.println(s + " = " + sum);
	}
		
}


