
public class UnaryAddMin {

	public static void main(String[] args) {
		short num1 = 5;
		System.out.println(+num1); //결과적으로 불필요한 + 연산
		System.out.println(-num1); //부호를 받꿔서 얻은 결과를 출력
		
		short num2 = 7;
		short num3 = (short)(+num2); //형 변환 필요
		short num4 = (short)(-num2); //형 변환 필요
		System.out.println(num3);
		System.out.println(num4);
	}

}
