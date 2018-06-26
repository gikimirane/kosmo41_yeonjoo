class calc
{
	int x1;
	int x2;
	
	calc()
	{
	}
	
	calc(int n1,int n2)
	{
		x1 = x1 + n1;
		x2 = x2 + n2;
	}
	int Add(int n1, int n2)
	{
		int nResult = (n1 + x1) + (n2 + x2);
		//System.out.println(nResult);
		return nResult;
	}
}

public class Exam01 {

	public static void main(String[] args) {
		
		int num1 = 5;
		int num2 = 7;
		
		calc mycal = new calc(num1,num2);    //클래스를 지정 생성 할때 new 사용
		int num3 = mycal.Add(num1, num2);
		
		int num4 = num3 * 10 - 20;
		System.out.println(num4);	

	}

}
