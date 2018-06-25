
public class LocalVariable {

	public static void main(String[] args) 
	{
		boolean ste = true;
		int num1 = 11;
		
		if(ste)
		{
	//		int num1 = 22;  같은 영역 내 동일 이름 변수 선언 불가
			num1++;
			System.out.println(num1);
		}
		
		{
			int num2 = 33;
			num2++;
			System.out.println(num2);
		}

	// 		System.out.println(num2); 윗쪽 중가로 내에서 선언한 변수는 지역 변수 이기때문에 여기서는 해당이 안됨 
	}

}


