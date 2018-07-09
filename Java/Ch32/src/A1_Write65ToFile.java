import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/*
 *  파일 대상 입출력 스트림 생성의 예 (덮어쓰기)
 */
class A1_Write65ToFile {

	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("data.dat"); //출력 스트림 생성
		out.write(65); // ASCII코드 65 = 'A'
		out.close();  //스트림 종료

	}

}
