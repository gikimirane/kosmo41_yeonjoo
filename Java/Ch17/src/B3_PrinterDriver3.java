interface Printable3 {
	void print (String doc);  // 공통이 되는 최상위 인터페이스  << 수정 X
}

interface ColorPrintable3 extends Printable3 {
	void printCMYK(String doc);     // Printable3 인터페이스를 상속받음 
}

												  // 새로운 프린터의 드라이버

class Prn909Drv3 implements ColorPrintable3 {     // 컬러프린트관련 내용 구현
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}

	@Override
	public void printCMYK(String doc) {    
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}

class B3_PrinterDriver3 {                       // 출력 

	public static void main(String[] args) {    // 최상위 인터페이스를 수정할 필요 없이
		String myDoc = "This is a report about..."; // 최상위 인터페이스 내용을 상속받은
		                                        // 새로운 인터페이스를 구현
		ColorPrintable3 prn = new Prn909Drv3();
		prn.print(myDoc);
		
		System.out.println();
		prn.printCMYK(myDoc);

	}

}
