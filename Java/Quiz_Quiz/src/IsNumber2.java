//
// 입력된 내용 숫자,문자 검증하기2
//  ㄴ try 문으로 검증

public class IsNumber2 {

	public static void main(String[] args) {
		String value = "12o34";
		String ch = "";
		boolean isNumber = true;
		
		for (int i=0; i<value.length(); i++) {
			ch = value.substring(i, i+1);  // 한글자씩 끊어서 검증
			//System.out.println(ch);
			
			try {
				int num = Integer.parseInt(ch);
			}catch(Exception e) {
				isNumber = false;
				break;                 // 간단한 검증이기 때문에 try를 쓰는 것은 낭비
			}
		}
		
		if (isNumber) {
			System.out.println(value + "는 숫자입니다.");
		}else {
			System.out.println(value + "는 숫자가 아닙니다.");
		}

	}

}
