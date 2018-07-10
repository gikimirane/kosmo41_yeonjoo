import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/*
 *  입출력 스트림 관련 코드의 개선 : try-with-resource 기반
 */

class A5_Write65ToFile3 {

	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("data.dat")) {
			out.write(65);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
