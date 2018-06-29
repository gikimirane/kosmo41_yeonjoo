abstract class Calc2  // <<< 추상클래스 Calc2
{
	int a;
	int b;
	abstract int result();  // <<< 추상메서드
	
	void printResult()
	{
		System.out.println(result());
	}
	
	void setData(int m,int n)
	{
		a = m;
		b = n;
	}
}

class Plus1 extends Calc2 //추상클래스Calc2를 상속받은 Plus1
{
	int result() { return a + b; }  // 오버라이딩
}

class Minus extends Calc2 //추상클래스Calc2를 상속받은 Minus
{
	int result() { return a - b; }  // 오버라이딩
}

class Calculation2 {                         // 출력

	public static void main(String[] args) 
	{
		int x = 54, y = 12;
		
		Calc2 calc1 = new Plus1();    //슈퍼(부모)클래스 = new 서브(자식)클래스
		Calc2 calc2 = new Minus();
		
		calc1.setData(x, y);
		calc2.setData(x, y);
		
		System.out.print(x + " + " + y + " = ");
		calc1.printResult();
		
		System.out.print(x + " - " + y + " = ");
		calc2.printResult();
		
	}

}
