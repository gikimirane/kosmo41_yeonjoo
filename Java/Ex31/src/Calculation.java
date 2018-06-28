// 추상클래스

// 추상클래스 (상위하위클래스의 관계도/연관성이 필요할때 사용)
// 추상클래스를 상속받는 클래스는 추상메서드만 구현하고 일반메서드는 사용하지 않아도 문제없음.



abstract class Calc // 1. 추상 메서드 
{
	int a;
	int b;
	abstract void answer();
	
	//void setData(int m,int n)
	//{
	//	a = m;
	//	b = n;
	//}
	
}

class Plus extends Calc // 2. 추상메서드에 대한 재정의 (재정의가 없을 경우 컴파일 에러)
{
	void answer()
	{
		System.out.println(a + " + " + b + " = " + (a+b));
	}
}

class Calculation { // 3. 재정의한 내용에 대한 결과 출력

	public static void main(String[] args) 
	{
		Plus plus = new Plus();
		//plus.setData(27,32);
		plus.answer();
		
	}
}
