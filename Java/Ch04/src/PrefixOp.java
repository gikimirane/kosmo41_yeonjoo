
public class PrefixOp {

	public static void main(String[] args) {
		int num1 = 7;
		System.out.println(++num1);
		System.out.println(++num1); //num�� �� �ϳ� ���� �� ���
		System.out.println(num1);
		
		System.out.println("--------------");
		
		int num2 = 5;
		System.out.println((num2++) + " "); //���� PostfixOp.java ����
		System.out.println((num2++) + " "); //��� �Ŀ� ���� ����
		System.out.println(num2);

		System.out.println("--------------");
		
		System.out.println((num2--) + " "); 
		System.out.println((num2--) + " "); //��� �Ŀ� ���� ����
		System.out.println(num2);
	}

}
