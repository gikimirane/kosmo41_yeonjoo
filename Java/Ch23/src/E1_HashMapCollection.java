import java.util.HashMap;
//
// Key-Value 방식의 데이터 저장과 HashMap<K,V> 클래스
//

class E1_HashMapCollection {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		
		//Key-Value 기반 데이터 저장
		map.put(45, "Browm");
		map.put(37, "James");
		map.put(23, "Martin");
		
		//데이터 탐색
		System.out.println("23번: " + map.get(23) + '\t'+ "37번: " + map.get(37)+ '\t' + "45번: " + map.get(45)+ '\t');
		
		System.out.println("23번: " + map.get(23));
		System.out.println("37번: " + map.get(37));
		System.out.println("45번: " + map.get(45));
		System.out.println();
		
		//데이터 삭제
		map.remove(37);
		
		//데이터 삭제 확인
		System.out.println("37번 : " + map.get(37));
		
	}

}
