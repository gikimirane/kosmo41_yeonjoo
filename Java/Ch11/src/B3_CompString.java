
public class B3_CompString {

	public static void main(String[] args) {
		String st1 = "A"; //Apple, Apple
		String st2 = "B"; //apple, Banana
		int cmp;
		
		//인스턴스의 내용 비교
		if(st1.equals(st2))
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
		
		cmp = st1.compareTo(st2);
		
		if(cmp == 0)
			System.out.println("두 문자열은 일치합니다.");
		else if (cmp <0)
			System.out.println("사전의 앞에 위치하는 문자 : " + st1);
		else
			System.out.println("사전의 앞에 위치하는 문자 : " + st2);
		// 두 문자의 크기를 비교해서 큰 쪽 작은 쪽을 비교
		
		if(st1.compareToIgnoreCase(st2) == 0)
			System.out.println("두 문자열은 같습니다.");
		else
			System.out.println("두 문자열은 다릅니다.");
		// 스펠링이 동일 할 경우 대소문자 관계 없이 같음

	}

}
