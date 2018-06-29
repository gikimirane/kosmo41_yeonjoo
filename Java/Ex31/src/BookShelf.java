
// 상속

// class AAA(서브*자식클래스) extends BBB(슈퍼*부모클래스)

class Book
{
	String title;
	String genre;

	void printBook()
	{
		System.out.println("제  목 : " + title);
		System.out.println("장  르 : " + genre);
	}
}

class Novel extends Book
{
	String writer;
	
	void printNov()
	{
		printBook();
		System.out.println("저  자 : " +writer);
	}
}

class Magazine extends Book
{
	int day;
	
	void printMag()
	{
		printBook();
		System.out.println("발매일 : " + day + "일");
	}
}

class BookShelf {

	public static void main(String[] args) 
	{
		Novel nov = new Novel();
		nov.title = "구운몽";
		nov.genre = "고전문학";
		nov.writer = "김만중";
		
		Magazine mag = new Magazine();
		mag.title = "월간 자바 그림책";
		mag.genre = "컴퓨터";
		mag.day = 20;
		
		nov.printNov();
		System.out.println();
		mag.printMag();

	}

}

// 오버라이딩은 메서드를 덮어쓰는기능
// 오버라이딩과 오버로딩의 차이점을 확실히 알아두기
// !!! 오버로딩 = 다중정의 , 오버라이딩 = 재정의 !!!
