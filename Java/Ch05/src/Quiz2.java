import java.util.Scanner;

public class Quiz2 {
	
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
		
		System.out.println("몇개의 수를 입력하시겠습니까?");
		
		int nCount = s.nextInt();
		double nSum = 0;
		
		for(int x = 0; x < nCount; x++)
		{
			System.out.println("정수를 입력하세요");
			int nInputNum = s.nextInt();
			    nSum = nSum + nInputNum ;
		}
		
		double result = nSum / nCount;
		System.out.println("입력하신 수의 평균 값은 " + result );
	
	} 
	
}	
