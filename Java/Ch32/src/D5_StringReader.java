import java.io.*;

/*
 * Buffered Reader 예제
 */

public class D5_StringReader {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src.txt"))) {
			String str;
			while(true) {
				str = br.readLine(); // 한 문장 읽어 들이기
				if(str == null)
					break;
				System.out.println(str);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
