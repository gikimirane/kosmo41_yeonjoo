interface Animal   // Animal 이라는 인터페이스 생성
{ 
	void cry();      //cry 라는 추상 메서드
}

class Cat2 implements Animal     // *Animal 인터페이스를 구현 
{
	public void cry()
	{
		System.out.println("냐~옹");
	}
}

class Dog2 implements Animal    // *Animal 인터페이스를 구현 
{
	public void cry()
	{
		System.out.println("왕왕!");
	}
}

public class CheckCry2 {                                   // Animal 재정의

	public static void main(String[] args) {
		Animal cat = new Cat2();
		Animal dog = new Dog2();
		
		checkAnimal(cat);                            // 체크 포인트
		checkAnimal(dog);
	}
		
	public static void checkAnimal(Animal animal) {	
		
		if(animal instanceof Cat2)             // CheckAnimal(cat)의 경우 출력
		{
			System.out.println("고먐미");
			animal.cry();                     
		}
		
		else if(animal instanceof Dog2)        // CheckAnimal(dog)의 경우 출력
		{
			System.out.println("댕댕이");
			animal.cry();
		}
	}

}
