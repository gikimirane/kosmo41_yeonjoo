import java.time.Duration;
import java.time.Instant;

/*
 * 시간이 얼마나 걸렸지? : Instant 클래스
 */
class A1_InstantDemo {

	public static void main(String[] args) {
		Instant start = Instant.now(); //현재 시각 정보를 담음
		System.out.println("시작 : " + start.getEpochSecond());
		// 반환 값은 '1970-01-01 00:00:00'을 기준으로 지나온 시간을 초 단위로 계산한 결과
		
		System.out.println("Time Flies like an arrow.");
		
		System.out.println("구구단 출력");
		
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
					System.out.println(i + " x " + j + " = " + ( i * j ));
				} System.out.println("-------------");	 
			}
		
		Instant end = Instant.now(); //현재 시각 정보를 담음
		System.out.println("끝 : " + end.getEpochSecond());
		
		Duration between = Duration.between(start, end); // 두 시각의 차를 계산
	//  ㄴ Duration은 시각차를 표현하기 위한 클래스
		
		System.out.println("밀리 초 단위 차 : " + between.toMillis());
	}

}

// 이 예제를 기반으로 별렬 스트림과 순차 스트림의 성능 테스트 코드를 작성할 수 있다.
