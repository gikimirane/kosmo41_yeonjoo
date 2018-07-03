//
// 인스턴스의 비교 : equals 메소드
// 다른 클래스에서 상속받아 '내용'을 비교 


class INum {
	private int num;
	public INum(int num ) {
		this.num = num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.num == ((INum)obj).num)
			return true;
		else
			return false;
	}
}

public class B1_ObjectEquality {

	public static void main(String[] args) {
		INum num1 = new INum(10);
		INum num2 = new INum(12);
		INum num3 = new INum(10);
		
		if(num1.equals(num2))
			System.out.println("num1, num2 내용이 동일하다.");
		else
			System.out.println("num1, num2 내용이 다르다.");
	
		if(num1.equals(num3))
			System.out.println("num1, num3 내용이 동일하다.");
		else
			System.out.println("num1, num3 내용이 다르다.");
	}

}
