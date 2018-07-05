import java.util.*;

class F_CopyList {

	public static void main(String[] args) {
		List<String> src = Arrays.asList("Box", "Apple","Toy","Robot");
		
		// 복사본을 만들어서 사용
		List<String> dest = new ArrayList<>(src);
		
		// 정렬하여 그 결과를 출력 [Apple, Box, Robot, Toy]
		Collections.sort(dest); 
		System.out.println(dest);
		
		// 사정상 정렬 이전의 상태로 되돌려야 함
		Collections.copy(dest, src);
		
		// 원래의 순서대로 출력된 것을 확인 [Box, Apple, Toy, Robot]
		System.out.println(dest);
	}

}
