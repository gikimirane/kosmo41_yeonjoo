class Calc
{   //설정명은 동일하지만 내용이 다른 것을 오버로딩이라고 함
	int add(int a, int b) 
	{
		return a + b; 
	}

	int add(int a)
	{
		return a + 1;		
	}
		
	double add(double a, double b)
	{
		return a + b;
	}
}

class Calculation

{
	public static void main(String[] args) 
	{
	
		Calc calc = new Calc();
		int nRtn1 = calc.add(3, 9);
		int nRtn2 = calc.add(3);
		double nRtn3 = calc.add(3.0, 9.0);
		
		System.out.println("Rtn1 = " + nRtn1);
		System.out.println("Rtn2 = " + nRtn2);
		System.out.println("Rtn3 = " + nRtn3);

	}

}
