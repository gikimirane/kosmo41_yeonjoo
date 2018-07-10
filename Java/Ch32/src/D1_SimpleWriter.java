import java.io.*;
import java.io.Writer;
/*
 *  문자 스트림 기반에서 문자를 저장하면 .. ?
 */

class D1_SimpleWriter {

	public static void main(String[] args) {
		try(Writer out = new FileWriter("data.txt")) { // 문자 출력 스트림 생성
			out.write('A');
			out.write('한');
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
