interface Printable5 {
	void print(String s);
}

class D2_Lambda {

	public static void main(String[] args) {
		Printable5 prn = new Printable5() { // 인터페이스를 가지고 만든 익명클래스
			public void print(String s) {  
				System.out.println(s);
			}
		};
		prn.print("What is Lambda?.......");
	}

}
