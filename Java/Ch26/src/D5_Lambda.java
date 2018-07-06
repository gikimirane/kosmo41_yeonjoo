//
// 파라미터가 여러 개일 때 
// ㄴ 메소드를 하나의 식으로 표현한 것 
// ㄴ (매개변수목록) -> { 함수몸체 }

interface PrintableE {
	void print(String s, int n);
}

class D5_Lambda {

	public static void main(String[] args) {
		PrintableE prn = (s,n) -> { System.out.println(s + " : " + n); };
		prn.print("What is Lambda?", 5);

	}

}
