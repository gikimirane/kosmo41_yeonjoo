import java.util.Scanner;

public class ForInFor {

	public static void main(String[] args) {
		
		// 3x3 표 형태 출력
		
		/* for(int i = 0; i < 3; i++) {  //바깥쪽 for문
			System.out.println("---------------");
			for(int j = 0; j < 3; j++) { //안쪽 for문
				System.out.print("|" + i + "," + j + "|");
			}
			System.out.print('\n');
		} */

		// 구구단 출력

		/* for(int i = 1; i < 10; i++) {  //바깥쪽 for문		
			for(int j = 1; j < 10; j++) { //안쪽 for문
				
				System.out.println(i + " x " + j + " = " + (i * j));
				
			}
			System.out.print('\n');
			System.out.println("--------------");
			*/
		
		// 구구단 출력 while문
		
		int num = 1;
		
		while(num < 10) {  
			
			for(int i = 1; i < 10; i++) { 
			for(int j = 1; j < 10; j++) { 			
				System.out.println(i + " x " + j + " = " + (i * j));	
			}
			num++;
			System.out.print('\n');
			System.out.println("--------------");
			}
			
		}
	}

}
