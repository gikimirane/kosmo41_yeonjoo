import java.util.*;

public class HashMap1 {

	public static void main(String[] args) {
		Map<String,String> testMap = new HashMap<String,String>();
		
/*	 
 * HashMap은 Map을구현한다. Key와 value를 묶어 하나의 entry로 저장 < 특징
 * 그리고 hashing을 사용하기 때문에 많은양의 데이터를 검색하는데 뛰어난 성능을 보임
 * Map 인터페이스의 한 종류로("Key",value)로 이뤄져 있다.
 * Key 값 중복이 불가 / value는 중복 가능 (null값도 사용가능)
 * 멀티쓰레드에서 동시에 HashMap을 건드려 Key - value값을 사용하면 문제가 될 수 있음
 * 멀티쓰레드 에서는 HashTable를 쓴다.
*/

		testMap.put("1번 댕댕이", "두부");
		testMap.put("2번 댕댕이", "휴지");
		testMap.put("3번 댕댕이", "모모");
		
		for(int i = 1; i <= testMap.size(); i++) {
			System.out.println(testMap.get((i + "번 댕댕이")));
		}
	}

}
