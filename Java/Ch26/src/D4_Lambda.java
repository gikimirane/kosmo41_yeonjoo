interface PrintableD {
	void print(String s);
}

class D4_Lambda {

	public static void ShowString(PrintableD p, String s) {
		p.print(s);
	}
	public static void main(String[] args) {
		ShowString((s) -> { System.out.println(s); }, "What is Lambda.....");
	}

}
