import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
 *  입출력 스트림 관련 코드의 개선 : try-with-resource 기반
 */

class A6_Read65FromFile3 {

	public static void main(String[] args) {
		try(InputStream in = new FileInputStream("data.dat")) {
			int dat = in.read();
			System.out.println(dat); // 인코딩된 숫자 출력
			System.out.printf("%c",dat); // 아스키 코드 출력
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
