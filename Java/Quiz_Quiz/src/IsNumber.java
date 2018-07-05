//
// 입력된 내용 숫자,문자 검증하기
// 

public class IsNumber {

	public static void main(String[] args) {
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		for(int i=0; i<value.length(); i++) {
			ch = value.charAt(i);   //( )안에 들어간 숫자가 인덱스 번호를 의미
			                        // ㄴ ** 인덱스 번호는 '0'부터 시작 **
			
			if(!(ch >= '0' && ch <='9') ) {
				isNumber = false;
				break;
			}
		}	
		// if((ch >= '0' && ch <='9') ) {
		//	} else {
		//		isNumber = false;
		//		break;
		//	}
	 // }
		
		if(isNumber) {
			System.out.println(value + "는 숫자입니다.");
		}else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}

	}

}

// 정보를 입력 받을 때 
// Scanner s = new Scanner(System.in);
// String num1 = s.nextLine.charAt(1); << 입력받은 문자열 중에 첫번째 글자만 입력받겠다는 의미
// ㄴ int가 아니고 char 형태로 입력을 받을 경우