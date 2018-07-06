//
// 로컬 클래스 
// ㄴ 로컬 클래스는 멤버클래스와 유사 
// ㄴ 지역 내에 정의된다는 점에서만 차이를 보임

interface Printable2 {
	void print(); 
}

class Papers2 {
	private String con;
	public Papers2(String s) { con = s; }

	public Printable2 getPrinter2() {
		// 메소드 안으로 감춤 
		class Printer implements Printable2 {
			public void print() {
				System.out.println(con);
			}
		}
		
		return new Printer();
	}
}
public class B3_UseLocalInner {

	public static void main(String[] args) {
		Papers2 p = new Papers2("서류 내용 : 매우 졸립니다 =ㅅ= zz");
		Printable2 prn = p.getPrinter2();
		prn.print();

	}

}
