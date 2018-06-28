// 인터페이스

// 인터페이스는 함수의 껍데기만 있음 
// 추상메서드와 상수로만 이루어져 있다.(=로직을 작성할 수 없음)
// 다중 상속이 가능하다.

// 인터페이스 사용 이유 : "함수"의 구현을 강제 구현 객체의 같은 "동작"을 보장
	
interface Greet 
{
	void greet();
}					// 1. 인터페이스 1
					//    인터페이스 2
interface Talk 
{
	void talk();
}
class Morning implements Greet,Talk 
{
	public void greet()					// 2. 인터페이스를 상속받을 때 
	{									//    Greet,Talk 메서드를 오버라이딩 해야만 함
		System.out.println("오하요!");  
	}
	
	public void talk()
	{
		System.out.println("오겡끼데스까");
	}
}

// * 인터페이스를 상속받는 클래스는 반드시 인터페이스에 있는 메서드를 다 구현해야 함
//   추상클래스를 상속받는 클래스는 추상메서드만 구현하고 일반메서드는 사용하지 않아도 문제 없음


class Meet {   	                       // 3.구현한 인터페이스에 대한 결과값을 출력

	public static void main(String[] args) {
		Morning morning = new Morning();
		morning.greet();
		morning.talk();
	}

}
