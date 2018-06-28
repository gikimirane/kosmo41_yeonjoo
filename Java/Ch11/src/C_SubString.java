
// 문자열 일부 추출

class C_SubString {

	public static void main(String[] args) {
		String st1 = "ABCDEFGH";
		
		String st2 = st1.substring(2);
		System.out.println(st2);
		
		// 3번째 칸의 자료부터 뒤까지 전부 출력

		String st3 = st1.substring(2,7);
		System.out.println(st3);

		// 3번째칸 부터 7번째칸까지 사이의 내용을 출력
		
		// substring(인자1, 인자2) 
		// 인자 1은 시작지점 index, 인자 2는 끝지점 index 중요중요!

		
		
		
	}

}
