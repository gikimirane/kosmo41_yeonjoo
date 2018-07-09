import java.util.*;

/*
 * 매개변수가 있고 반환하는 람다식2
 */

interface HowLong {
	int len(String s); //값을 반환하는 메소드
}

class A5_OneParamAndReturn {

	public static void main(String[] args) {

		HowLong h1 = s -> s.length();
		
		System.out.println(h1.len("I am so happy")); //텍스트의 길이를 구한 값을 출력

	}

}
