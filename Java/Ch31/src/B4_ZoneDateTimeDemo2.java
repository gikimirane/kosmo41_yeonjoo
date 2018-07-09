import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * 시간대를 반영한 예제
 * ㄴ From 한국 to 프랑스 비행에 걸린 시간은?
 */


class B4_ZoneDateTimeDemo2 {

	public static void main(String[] args) {
		// 한국 출발 2018-07-09 14:30
		ZonedDateTime departure = ZonedDateTime.of(
				LocalDateTime.of(2018, 7, 9, 14, 30), ZoneId.of("Asia/Seoul"));
		System.out.println("Departure : " + departure);
		
		// 파리 도착 2018-07-09 17:25
		ZonedDateTime arrival = ZonedDateTime.of(
				LocalDateTime.of(2018, 7, 9, 17, 25), ZoneId.of("Europe/Paris"));
		System.out.println("Arrival : " + arrival);
				
		// 비행 시간
		System.out.println(Duration.between(departure, arrival));
	}

}
