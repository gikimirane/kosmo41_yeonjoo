import java.io.*;

/*
 * FileWriter 예제
 */

public class D3_TextWriter {

	public static void main(String[] args) {
	
		try(Writer out = new FileWriter("data1.txt")) { // 문자 출력 스트림 생성
			for(int ch = (int)'A'; ch < (int)('Z'+1); ch++)
				out.write(ch);
			
			out.write(13); // \r
			out.write(10); // \n 의 의미로 줄바꿈의 의미
			
			for(int ch = (int)'A'+32; ch < (int)('Z'+1+32); ch++) 
	//		아스키코드 대문자 'A' 시작은 65 , 소문자 'a' 시작은 97이라서 'A'+32로 소문자 출력
				out.write(ch);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
