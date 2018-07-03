import java.util.Arrays;

//
// 배열의 정렬 : Arrays 클래스의 sort 메소드
//

class H6_ArraySort {

	public static void main(String[] args) {
		int[] ar1 = {1,2,3,4,5};
		double[] ar2 = {3.3, 2.2, 5.5, 1.1, 4.4};
		
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		// 매개변수 a로 전달된 배열을 오름차순으로 정렬 
		
		for(int n : ar1)
			System.out.print(n + "\t");
		System.out.println();
		
		for(double d : ar2)
			System.out.print(d + "\t");
		System.out.println();

	}

}
