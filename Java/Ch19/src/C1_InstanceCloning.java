//
// clone 메소드 호출의 예
//
class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d,%d]",xPos, yPos);
		System.out.println();
	}
	
	//접근 수준 지시자를 protected 에서 public으로 바꾸기 위한 메소드 오버라이딩
	
	@Override 
	public Object clone() throws CloneNotSupportedException {
		return super.clone();  //Object 클래스의 clone 메소드를 호출
	}
}



class C1_InstanceCloning {

	public static void main(String[] args) {  
		Point org = new Point(3,5);           
		Point cpy;
		
		try {
			cpy = (Point)org.clone();
			org.showPosition();
			cpy.showPosition();
			
			
			if(org.equals(cpy))
				System.out.println("str1, str2 내용 동일하다.");
			else
				System.out.println("str1, str2 내용 다르다.");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// Cloneable 인터페이스를 구현해야 메소드 호출 가능
		// Cloneable 인터페이스를 구현 하지 않는 클래스의 인스턴스에서 
		// clone 메소드가 호출 되면 ' CloneNotSupportedException ' 예외가 발생
	}

}
