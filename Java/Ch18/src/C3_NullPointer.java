//
// 구해야할 값이 Null 인 것에 대한 오류
// ㄴNullPointerException

class C3_NullPointer {

	public static void main(String[] args) {
		String str = null;   // null 출력
		System.out.println(str);
		 
		int len = str.length();       // 오류발생시점

		// if(str != null) {          // 오류가 발생하지 않도록 수정
		// int len = str.length();
		// }
	
	}

}
