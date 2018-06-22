
public class BreakBasic1 {

	public static void main(String[] args) {
		int num = 1;
		boolean search = false;
		// 100 아래 5와7의 공배수를 전체 찾는 문
		while(num < 100) {
			if(((num % 5) == 0) && ((num % 7) == 0)) {
				System.out.println("찾는 정수 : " + num );
			}
			num++;
			}			

		}

}