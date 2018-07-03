import java.util.Scanner;

public class Quiz_13_4_1 {

	public static void main(String[] args) {
		
		
		// 숫자 10개를 받아서 nTmp에 저장
		
		Scanner s = new Scanner(System.in);
		
		int[] num = new int[10];
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println("10 개의 숫자를 입력하세요");
			int nTmp = s.nextInt();
			num[i] = nTmp;
		}
		
		//결과 출력
		
		int addCnt = 0;
		int evenCnt = 9;
		
		for(int i=0; i<num.length;i++)  // 어느 범주내에서 반복할 건지
		{
			System.out.println("숫자를 입력하세요");
			int nTmp = s.nextInt();
			if( nTmp % 2 == 0 )   // if 문에 맞는 내용이면
					{ num[evenCnt] = nTmp; // 어딘가에 저장
						evenCnt++;
					}	
						// 홀수도 한 번 추가해보기!!
		}

	}
}

