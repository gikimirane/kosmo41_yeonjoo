
public class BreakBasic1 {

	public static void main(String[] args) {
		int num = 1;
		boolean search = false;
		// 100 �Ʒ� 5��7�� ������� ��ü ã�� ��
		while(num < 100) {
			if(((num % 5) == 0) && ((num % 7) == 0)) {
				System.out.println("ã�� ���� : " + num );
			}
			num++;
			}			

		}

}