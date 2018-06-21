
public class PrefixOp {

	public static void main(String[] args) {
		int num1 = 7;
		System.out.println(++num1);
		System.out.println(++num1); //num의 값 하나 증가 후 출력
		System.out.println(num1);
		
		System.out.println("--------------");
		
		int num2 = 5;
		System.out.println((num2++) + " "); //교재 PostfixOp.java 내용
		System.out.println((num2++) + " "); //출력 후에 값이 증가
		System.out.println(num2);

		System.out.println("--------------");
		
		System.out.println((num2--) + " "); 
		System.out.println((num2--) + " "); //출력 후에 값이 감소
		System.out.println(num2);
	}

}
