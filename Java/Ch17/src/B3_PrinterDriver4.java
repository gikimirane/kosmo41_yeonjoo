interface Printable4{
	void print(String doc);
	default void printCMYK(String doc) {}  //디폴트 메서드
} 										   // ㄴ 자체로 완전한 메서드 ( 가상메서드 X )

class Prn731Drv4 implements Printable4 {    
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}
}

class Prn909Drv4 implements Printable4 {     
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}

class B3_PrinterDriver4 {
	
	public void printCMYK(String doc) {    
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}

	
}

