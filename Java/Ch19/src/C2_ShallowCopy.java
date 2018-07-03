//
// 일반적으로 Clone를 할 경우, 1단계부분만 Copy되고 그 안의 참조 내용은 Copy가 되지 않음
// ㄴ 이것을 'Shallow Copy (얕은 복사)' 라고 한다.
//

class Point2 implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point2(int x, int y) {
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

class Rectangle2 implements Cloneable {
	 Point2 upperLeft;  //좌측 상단 좌표
	 Point2 lowerRight; //우측 상단 좌표
	
	public Rectangle2(int x1, int y1, int x2, int y2) {
		upperLeft = new Point2(x1,y1);
		lowerRight = new Point2(x2,y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2,y2);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();
			
		System.out.print("우측 하단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
}
	
public class C2_ShallowCopy {
	
	public static void main(String[] args) {
		
		 Rectangle2 org = new Rectangle2(1,1,9,9);
		 Rectangle2 cpy;
		
		try {
			//인스턴스 복사
			cpy = (Rectangle2)org.clone();
			
			//한 인스턴스의 좌표 정보를 수정
			org.changePos(2, 2, 7, 7);
			
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("1단계 같음");  // 복사시에 69번 라인 수정 좌표정보 반영
			else
				System.out.println("1단계 다름");
			
			if(org.lowerRight.equals(cpy.lowerRight))
				System.out.println("2단계 같음");  // 2단계 이 부분까지는 복사가 되지 않음
			else
				System.out.println("2단계 다름");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
			
	}

}


