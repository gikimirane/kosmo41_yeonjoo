//
// system.out.print의 '출력' 형태 1
//

/*
 파일이름 : BlockComment.java
 작성자 : 홍길동
 작성일 : 2019년 7월 25일
 목  적 : System.out.println 메소드의 기능 테스트
 */

class BlockComment
{
	public static void main(String[] args)
	{
		/* 다음은 단순한 정수의 출력 */
		System.out.println(7);   //정수출력 		
		System.out.println(3.15);
		System.out.println("3 + 5 = " + 8);
		System.out.println(3.15+ "는 실수입니다.");
		System.out.println("3 + 5" + " 의 연산 결과는 8입니다.");
		
		/* 다음은 덧셈 결과의 출력 */
		System.out.println(3 + 5);
	}
}