import java.util.*;
//
// 중복된 인스턴스의 삭제
//

public class C5_ConvertCollection {

	public static void main(String[] args) {
		List<String> lst = Arrays.asList("Toy","Box","Box", "Toy");
		ArrayList<String> list = new ArrayList<>(lst);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
		
		//중복된 인스턴스를 걸러 내기 위한 작업
		HashSet<String> set = new HashSet<>(list);  
		             //       ㄴ 중복을 허용 않는 집합 ("Box" "Toy"가 중복되기 떄문에 삭제)
		
		//원래대로 ArrayList<String> 인스턴스로 저장물을 옮긴다.
		list = new ArrayList<>(set); //순서 자동정렬
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}

}
