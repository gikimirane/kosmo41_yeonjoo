//
// 파라미터로 람다식을 넘길 때
//

interface Printable6 {
	void print(String s);  // 추상 메소드가 하나인 인터페이스
}

 class D3_Lambda {

	public static void main(String[] args) {
		Printable6 prn = (s) -> { System.out.println(s); };
		prn.print("What is Lambda?????ㅠ_ㅠ");

	}

}
