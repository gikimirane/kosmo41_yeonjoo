import java.util.Scanner;

public class ForInFor {

	public static void main(String[] args) {
		
		// 3x3 ǥ ���� ���
		
		/* for(int i = 0; i < 3; i++) {  //�ٱ��� for��
			System.out.println("---------------");
			for(int j = 0; j < 3; j++) { //���� for��
				System.out.print("|" + i + "," + j + "|");
			}
			System.out.print('\n');
		} */

		// ������ ���

		/* for(int i = 1; i < 10; i++) {  //�ٱ��� for��		
			for(int j = 1; j < 10; j++) { //���� for��
				
				System.out.println(i + " x " + j + " = " + (i * j));
				
			}
			System.out.print('\n');
			System.out.println("--------------");
			*/
		
		// ������ ��� while��
		
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
