import java.math.BigDecimal;

//
// 오차 없는 실수 표현을 위한 BigDecimal
//

public class D2_WOwBigDecimal {

	public static void main(String[] args) {
		BigDecimal d1 = new BigDecimal("1.6");
		BigDecimal d2 = new BigDecimal("0.1");
		
		System.out.println("덧셈결과: " + d1.add(d2));
		System.out.println("곱셈결과: " + d1.multiply(d2));

	}

}
