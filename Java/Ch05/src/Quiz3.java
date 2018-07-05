
public class Quiz3 {

	public static void main(String[] args) {
		
		int result = 1;
		
		System.out.println(" 1이상 100 미만의 정수 중에서 7과 9의 배수는? ");
		
		while(result < 100) {
			if(((result % 7) == 0) || ((result % 9) == 0)) {
				System.out.print( result + " " );
				
			}
			result++;
			} 
		
//		System.out.println("1이상 100 미만의 정수 중에서 7과 9의 배수는?");
//		
//		for (int C=1; C < 100; C++) {
//			if ((C % 7) == 0 || (C % 9) == 0)
//				System.out.print( C + " " );
//		}
		
	}

}
