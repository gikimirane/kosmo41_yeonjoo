import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class B5_DateTimeFormatterDemo {

	public static void main(String[] args) {
		ZonedDateTime date = ZonedDateTime.of(
				LocalDateTime.of(2019, 4, 25, 11, 20), ZoneId.of("Asia/Seoul"));
		
		// 출력의 포맷 정보는 java.time.format.DateTimeFormatter 인스턴스에 담는다.
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yy-M-d");
		DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-d, H:m:s");
		DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-d, HH:mm:ss VV");
		DateTimeFormatter fm4 = DateTimeFormatter.ofPattern("yyyy-MMM-d, a HH:mm:ss  VV");
	     // M은 월, m 은 분, MMM은 해당나라 '월' 'JUL' 등의 표기 방법, a 는 AM/PM 출력
													
		
		// LocalDate.LocalTime.LocalDateTime.ZonedDateTime에 모두 존재하는 format 메소드 호출한다.
		
		System.out.println(date.format(fm1));
		System.out.println(date.format(fm2));
		System.out.println(date.format(fm3));
		System.out.println(date.format(fm4));
		

	}

}
