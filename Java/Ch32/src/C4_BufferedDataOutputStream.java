import java.io.*;
import java.io.IOException;
/* 
 * 파일에 기본 자료형 데이터를 저장 + 버퍼링 기능 추가 (넣기)
 */

class C4_BufferedDataOutputStream {

	public static void main(String[] args) {
		try(DataOutputStream out = 
				new DataOutputStream(
						new BufferedOutputStream(
								new FileOutputStream("data.dat")))) {
				out.writeInt(370);
				out.writeDouble(3.14);
			}
			catch(IOException e) {
				e.printStackTrace();
			}

	}

}
