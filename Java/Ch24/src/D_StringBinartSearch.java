import java.util.*;

//
// 찾기의 예
//

class D_StringBinartSearch {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		
		//sort 이용 정렬
		Collections.sort(list);  
		
		//탐색
		int idx = Collections.binarySearch(list, "Robot"); 
		
		//탐색한 결과 출력
		System.out.println(list.get(idx)); 

	}

}
