class Calc2
{
	int add(int a, int b)
	{
		return a + b;
	}
}

class Calculation 
{
    // main() 메서드와 같은 오브젝트 내의 메서드에는 static을 붙인다

	static void disp() 
	{
		int nRtn;
		Calc2 calc = new Calc2();  //Calc2 : 클래스명 clac : 참조변수
		nRtn = calc.add( 3, 9 );
		
		System.out.println("3 + 9 = " + nRtn);
	}
	public static void main(String[] args) 
	{
		disp();
	}

}
