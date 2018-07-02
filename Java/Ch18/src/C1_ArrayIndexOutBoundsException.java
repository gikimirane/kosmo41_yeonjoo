//
// 인덱스 범위를 벗어났을 경우 생기는 오류
// ㄴ ArrayIndexOutOfBoundsException 

class C1_ArrayIndexOutBoundsException {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		for(int i = 0; i < 4; i++)
			System.out.println(arr[i]);  //인덱스 값 3은 예외를 발생시킴
	}

}
