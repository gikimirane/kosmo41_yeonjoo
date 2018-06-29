interface Greet1      // 인터페이스 (꾸러미1)
{
	void greet();
}

interface Bye extends Greet1 //인터페이스 요소1을 상속받은 인터페이스 (꾸러미2)

{
	void bye();
}
class Greeting implements Bye // 인터페이스(꾸러미1)을 포함하여 상속받은 꾸러미1,2를 오버라이딩
{
	public void greet()       // ㄴ꾸러미 안에 구체적인 동작을 "재정의"
	{
		System.out.println("곤니찌와!");
	}
	public void bye()
	{
		System.out.println("오야스미~");
	}
}
class Meet_1 {               // 정의한것에 대한 결과값 출력

	public static void main(String[] args) 
	{
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}

}
