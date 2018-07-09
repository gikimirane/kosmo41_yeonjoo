import java.time.LocalDate;
import java.time.Period;
/*
 *  날짜의 차를 표현하기 위한 Period 클래스 (LocalDate : 날짜정보를 나타냄)
 */
class A5_LocalDateDemo2 {

	public static void main(String[] args) {
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);
			
		// 올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas : " + xmas);		
		
		// 크리스마스까지 앞으로 며칠?
		Period left = Period.between(today, xmas);
		System.out.println("Xmas 까지 앞으로 " +
		left.getMonths() + "개월 " +  left.getDays() + "일");

	}

}

// Period : 두 날짜 사이의 [년,월,일]로 표현되는 기간 
// (시간을 다루지 않다 보니 LocalDate를 사용한다)
	
// public int getYears() Period의 메소드
// public int getMonths() Period의 메소드
// public int getDays() Period의 메소드
