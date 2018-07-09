import java.time.LocalDate;

/*
 *  오늘이 며칠이죠? : LocalDate 클래스
 */
class A4_LocalDateDemo1 {

	public static void main(String[] args) {
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today : " + today);
		
		// 올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas : " + xmas);
		
		// 올 해의 크리스마스 이브
		LocalDate eve = xmas.minusDays(1); // 지정날짜에서 빼기
		System.out.println("Xmas Eve : " + eve);

	}

}
