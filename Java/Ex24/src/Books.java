class MyBook
{
	int price;
	int num = 0;
	String title;
	
// MyBook()
//	{
//		디폴트 생성자 *인수가 없는 상태에서 자동으로 만들어지는 것
//	}
	
	MyBook()
	{
		title = "모바일게임교육";
		price = 5000;
	}
	
	MyBook(String t, int p)
	{
		title = t;
		price = p;
	}
	
	void print()
	{
		System.out.println("제    목 : " + title);
		System.out.println("가    격 : " + price);
		System.out.println("주문수량 : " + num);
		System.out.println("합계금액 : " + price * num);
	}
}

class Books 
{
	public static void main(String[] args) 
	{
		MyBook book = new MyBook();
	 // MyBook book = new MyBook("게임스쿨", 10000); 
	 // 위 생성자에서 동일한 타입의 자료를 가지고 와서 출력
		book.num = 10;
		book.print();
	}

}
