//
// Clone할 부분을 지정할 경우, 2단계부분까지 깊은 복사 진행
// ㄴ 이것을 'Deep Copy (깊은 복사)' 라고 한다.
//

class Point3 implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point3(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d,%d]",xPos, yPos);
		System.out.println();
	}
	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Rectangle3 implements Cloneable {
	 Point3 upperLeft;  //좌측 상단 좌표
	 Point3 lowerRight; //우측 상단 좌표
	
	public Rectangle3(int x1, int y1, int x2, int y2) {
		upperLeft = new Point3(x1,y1);
		lowerRight = new Point3(x2,y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2,y2);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Rectangle3 copy = (Rectangle3)super.clone();
		
		copy.upperLeft = (Point3)upperLeft.clone();
		copy.lowerRight = (Point3)lowerRight.clone();
		
		return copy;
		
	}
	
	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();
			
		System.out.print("우측 하단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
}
	
public class C3_DeepCopy {
	
	public static void main(String[] args) {
		
		 Rectangle3 org = new Rectangle3(1,1,9,9);
		 Rectangle3 cpy;
		
		try {
			//인스턴스 복사
			cpy = (Rectangle3)org.clone();
			
			//한 인스턴스의 좌표 정보를 수정
			org.changePos(2, 2, 7, 7);
			
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("1단계 같음");  // 복사시에 69번 라인 수정 좌표정보 반영
			else
				System.out.println("1단계 다름");
			
			if(org.lowerRight.equals(cpy.lowerRight))
				System.out.println("2단계 같음");  // 2단계부분까지 복사 진행
			else
				System.out.println("2단계 다름");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
			
	}

}

// * String 인스턴스 대상 깊은 복사 *

// @Override
// public Object clone() throws CloneNotSupportedException {
// Person cpy = (Person)super.clone();  << clone 메소드 호출을 통한 복사본 생성
// cpy.name = new String(name);  << 깊은 복사의 형태로 복사본을 완성
// return cpy; << 완성된 복사본의 참조 값 반환

//