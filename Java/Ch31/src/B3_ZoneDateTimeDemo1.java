import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/*
 *  시간대를 반영한 ZonedDateTime 클래스
 */

class B3_ZoneDateTimeDemo1 {

	public static void main(String[] args) {
		// 이곳의 현재 날짜와 시각
		ZonedDateTime here = ZonedDateTime.now();
		System.out.println(here);

		// 동일한 날짜와 시각의 파리
		ZonedDateTime paris = ZonedDateTime.of(
				here.toLocalDateTime(),ZoneId.of("Europe/Paris"));
	        	// 날짜와 시각 정보만 LocalDateTime 인스턴스에 담아서 반환
		System.out.println(paris);
		
		// 이곳과 파리의 시차
		Duration diff = Duration.between(here, paris);
		System.out.println(diff);
	}

}
