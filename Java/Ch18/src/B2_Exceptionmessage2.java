//
// 예외의 전달 : 10번라인에서 발생한 에러가 > 7번 > 14번라인(메인처리 지점으로 전달 된다)
//

class B2_Exceptionmessage2 {
	public static void md1(int n) {
		md2(n,0);  // 이 지점으로 md2 예외(오류)가 넘어온다. (순서 2)
	}
	public static void md2(int n1,int n2) {
		int r = n1 / n2;   //예외(오류) 발생 시점 (순서 1)
	}
	public static void main(String[] args) {
		try {
			md1(3);        // 이지점에서 md1으로부터 예외가 넘어온다. (순서 3)
		}
		catch(Throwable e ) {       //Throwable 예외의 전달
			e.printStackTrace();
		}
		System.out.println("Good bye~~!");

	}

}

//at B2_Exceptionmessage2.md2(B2_Exceptionmessage2.java:10)  * 오류가 난 지점
//at B2_Exceptionmessage2.md1(B2_Exceptionmessage2.java:7) 
//at B2_Exceptionmessage2.main(B2_Exceptionmessage2.java:14) * 처리는 메인이 ...