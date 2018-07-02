//
// 자식의 오브젝트 > 부모의 오브젝트 대입에 대한 오류
// ㄴ ClassCastException

class Board { }

class PBoard extends Board { }

class C2_ClassCast {

	public static void main(String[] args) {
		Board pbd1 = new PBoard();
		PBoard pbd2 = (PBoard)pbd1;  // 자식의 오브젝트를 부모의 오브젝트에 대입 가능
		
		System.out.println(".. intermediate location ..");
		Board ebd1 = new Board();
		PBoard ebd2 = (PBoard)ebd1; // 부모 오브젝트에 자식 오브젝트를 대입은 불가능 

	}

}
