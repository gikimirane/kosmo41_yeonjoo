/*
 * 매개변수가 있고 반환하는 람다식1
 */

interface Calculate1 {
	int cal(int a, int b); //값을 반환하는 추상 메소드
}

class A4_TwoParamAndReturn {

	public static void main(String[] args) {
		Calculate1 c;
		c = (a, b) -> { return a + b; }; // return문의 중괄호는 생략 불가!
		System.out.println(c.cal(4, 3)); // 연산결과가 남는 식
		
		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));

	}

}
// 메서드 몸체에 해당하는 내용이 return문 이면,
// 그문장이 하나이더라도 중괄호의 생략이 불가능하다