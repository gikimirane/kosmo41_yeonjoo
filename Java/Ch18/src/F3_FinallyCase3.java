//
// finally 구문의 사용의 예
//

import java.util.Scanner;

public class F3_FinallyCase3 {

	public static void main(String[] args) {
		 
		int num;
		
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
	
		try {
			num = a / b;                  //b 숫자에 '0' 을 넣게 되면 수학적 오류 발생 
		} catch(Exception e) {
			// e.printStackTrace();
			num = 0;       // 에러가 났을 때 어떤 값을 초기화 함으로서 오류 수정         
		} finally {
			// 데이터 베이스 접속종료 등 .. 무조건 해야 할 일	
			//num = num + 1;   
			}

		System.out.println(num);

	}

}
