import java.time.LocalDate;
import java.time.LocalTime;

// static 초기화 블록

class C1_DataOfExecution {
	static String date;
	
	//인스턴스 생성과 관계없이 static 변수가 메모리 공간에 할당될 때 실행 됨
	static {
		LocalDate nDate = LocalDate.now();
		//LocalTime nTime = LocalTime.now();
		date = nDate.toString();

		
	}
	
	public static void main(String[] args) {
		System.out.println(date);
	}

}

// 시간도 같이 출력 하는거 해보기!
