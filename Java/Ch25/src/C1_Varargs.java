//
// 매개변수의 가변 인자 선언과 호출
//

class C1_Varargs{
	public static void showAll(String... vargs) {
		                               //ㄴvargs를 배영읠 참조변수로 간주하고 코드작성  
		System.out.println("LEN: " + vargs.length);
		
		for(String s : vargs)
			System.out.print(s + '\t');
		System.out.println();
	}

	public static void main(String[] args) {
		showAll("Box");
		showAll("Box","Toy");
		showAll("Box","Toy","Apple");		
		
	}

}
