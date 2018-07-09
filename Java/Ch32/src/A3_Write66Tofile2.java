import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 *  입출력 스트림 관련 코드의 개선 : finally 기반 close
 */

class A3_Write66Tofile2 {

	public static void main(String[] args) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream("data.dat");
			out.write(66);
		}
		finally {
			if(out != null) //출력 스트림 생성 성공했으면,
				out.close();
		}
		

	}

}
