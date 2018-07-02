//
// 랩퍼 클래스 > 문자열과 수치는 계산 X > 문자열을 수치로 변환한다.
//

class Change {

	public static void main(String[] args) {
		String a = "34";                     // "34" 문자열
		int b = 50;                          // 수치
		int c = Integer.parseInt(a);         // a의 문자열을 수치로 변환
		int d = c + b;
		System.out.println(a + " + " + b + " = " + d );
	}

}
