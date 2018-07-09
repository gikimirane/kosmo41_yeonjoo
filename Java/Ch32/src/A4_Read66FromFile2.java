import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
 *  입출력 스트림 관련 코드의 개선 : finally 기반 close
 */

class A4_Read66FromFile2 {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream("data.dat");
			int dat = in.read();
			System.out.println(dat);
			System.out.printf("%c",dat);
		}
		finally {
			if(in != null) //입력 스트림 생성 성공했으면,
			   in.close();
		}
	
	}

}
