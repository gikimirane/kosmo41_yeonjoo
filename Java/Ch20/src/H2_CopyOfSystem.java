//
// arraycopy 메소드 호출의 예
//  ㄴ 이미 만들어져 있는 array를 복사하는 형태

public class H2_CopyOfSystem {

	public static void main(String[] args) {
		double[] org = {1.1, 2.2, 3.3, 4.4, 5.5};
		double[] cpy = new double[3];
		
		//배열 org의 인덱스 1에서 배열 cpy 인덱스 0으러 세 개의 요소 복사
		System.arraycopy(org, 1, cpy, 0, 3);
		
		for(double d : cpy)
			System.out.print(d + "\t");
		System.out.println();
	}

}
