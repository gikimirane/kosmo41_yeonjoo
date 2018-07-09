import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 *  파일 대상 입출력 스트림 생성의 예 (인코딩)
 */

class A2_Read65FromFile {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("data.dat"); // 입력 스트림 생성
			int dat = in.read(); // 데이터를 읽음
			in.close();          // 스트림 종료
			
			System.out.println(dat); // 숫자로 인코딩 되서 출력
			System.out.printf("%c",dat); // 아스키코드 출력
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
