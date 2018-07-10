import java.io.*;
import java.io.IOException;

/* 
 * 파일에 기본 자료형 데이터를 저장 + 버퍼링 기능 추가 (꺼내기)
 */

class C5_BufferedDataInputStream {

	public static void main(String[] args) {
		try(DataInputStream in = 
				new DataInputStream(
						new BufferedInputStream(
								new FileInputStream("data.dat")))) {
			int num1 = in.readInt();
			double num2 = in.readDouble();
			
			System.out.println(num1);
			System.out.println(num2);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
