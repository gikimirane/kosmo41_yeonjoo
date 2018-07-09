import java.time.LocalTime;
/*
 *  2시간 10분 뒤에 어때? : LocalTime 클래스 (LocalTime : 시간정보를 나타냄)
 */
class A6_LocalTimeDemo1 {

	public static void main(String[] args) {
		// 현재 시각
		LocalTime now = LocalTime.now();
		System.out.println("지금 시각 : " + now);
		
		// 2시간 10분 뒤 화상 미팅 예정
		LocalTime mt = now.plusHours(2);  // 시간 단위
		mt = mt.plusMinutes(10);    // 분 단위
		
		// 화상 미팅 시각
		System.out.println("화상 미팅 시각 : " + mt);

	}

}


// public LocalTime plusHours(long hoursToAdd) LocalTime의 메소드
// public LocalTime plusHours(long minutesToAdd) LocalTime의 메소드
// public LocalTime plusHours(long secondstoAdd) LocalTime의 메소드
