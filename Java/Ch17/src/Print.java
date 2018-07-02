interface Printable     //인터페이스 생성
{
	public void print(String doc);
}

	class SPrinterDriver implements Printable {   // Printable 인터페이스 구현
		@Override
		public void print(String doc) {
			System.out.println("From Samsung printer");
			System.out.println(doc);
		}
	} 
	class LPrinterDriver implements Printable {  // Printable 인터페이스 구현
		@Override
		// 오버라이딩은 메서드명과 파라미터 모두 상위 클래스와 동일 해야 함	
		public void print(String doc) {
			System.out.println("From LG printer");
			System.out.println(doc);
		}
	}

class Print {

	public static void main(String[] args) {  // 출력
		
		String myDoc = "This is a report about...";
		
		// 삼성 프린터로 출력
		Printable prn = new SPrinterDriver();
		prn.print(myDoc);
		System.out.println();

		// LG 프린터로 출력
		prn = new LPrinterDriver();
		prn.print(myDoc);
	}

}
