//
// 익명클래스
//

interface Printable3{
	void print();
}

class Papers3 {
	private String con;
	public Papers3(String s) { con = s; }
	
	public Printable3 getPrinter() {
		return new Printable3() {
			public void print()
			{ System.out.println(con);}
		};  //;을 붙인 이유? >>> return; / return내용;  
	}
}
class B4_UseAnonymousInner {

	public static void main(String[] args) {
		Papers3 p = new Papers3("서류 내용 : 쉽게 얻어지는 것은 없음ㅠ_ㅠ");
		Printable3 prn = p.getPrinter();
		prn.print();

	}

}
