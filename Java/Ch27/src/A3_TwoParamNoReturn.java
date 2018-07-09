/*
 * 매개변수가 둘인 람다식
 */

interface Calculate {
	void cal(int a, int b); // 매개변수 둘, 반환형 void
}

class A3_TwoParamNoReturn {

	public static void main(String[] args) {
		Calculate c;
	//  c = (a, b) -> System.out.println("aaa"); 로 쓰면 aaa만 출력 	
		c = (a, b) -> System.out.println(a + b); // << 연산결과가 남지 않고 
		c.cal(4, 3); //덧셈 진행                       단지 내용 출력만 하는 용도 
		
		c = (a, b) -> System.out.println(a - b);
		c.cal(4, 3); //뺄셈 진행
		
		c = (a, b) -> System.out.println(a * b);
		c.cal(4, 3); //곱셈 진행

	}

}
