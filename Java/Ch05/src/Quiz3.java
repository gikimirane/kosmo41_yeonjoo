
public class Quiz3 {

	public static void main(String[] args) {
		
		/* int result = 1;
		
		System.out.println("7�� 9�� ����� �ش��ϴ� ���� ?");
		
		while(result < 100) {
			if(((result % 7) == 0) || ((result % 9) == 0)) {
				System.out.print( result + " " );
				
			}
			result++;
			} */
		
		System.out.println("7�� 9�� ����� �ش��ϴ� ���� ?");
		
		for (int C=1; C < 100; C++) {
			if ((C % 7) == 0 || (C % 9) == 0)
				System.out.print( C + " " );
		}
		
	}

}
