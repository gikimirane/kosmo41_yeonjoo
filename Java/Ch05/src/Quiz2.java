import java.util.Scanner;

public class Quiz2 {
	
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
		
		System.out.println("��� ���� �Է��Ͻðڽ��ϱ�?");
		
		int nCount = s.nextInt();
		double nSum = 0;
		
		for(int x = 0; x < nCount; x++)
		{
			System.out.println("������ �Է��ϼ���");
			int nInputNum = s.nextInt();
			    nSum = nSum + nInputNum ;
		}
		
		double result = nSum / nCount;
		System.out.println("�Է��Ͻ� ���� ��� ���� " + result );
	
	} 
	
}	
