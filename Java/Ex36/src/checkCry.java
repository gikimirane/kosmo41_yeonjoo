interface Cry   // 인터페이스 생성
{ 
	void cry();
}

class Cat implements Cry     // *Cry 인터페이스를 구현 
{
	public void cry()
	{
		System.out.println("냐옹~");
	}
}

class Dog
{
	public void cry()
	{
		System.out.println("왕왕!");
	}
}

class checkCry {                                   // 결과값 출력

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		if(cat instanceof Cry)             //인터페이스 Cry 와 관련이 있으면 출력
		{
			cat.cry();                     //Cat은 인터페이스를 구현 > 출력
		}
		
		if(dog instanceof Cry)             //DOg는 인터페이스를 구현X > 미출력
		{
			dog.cry();
		}
	}

}
