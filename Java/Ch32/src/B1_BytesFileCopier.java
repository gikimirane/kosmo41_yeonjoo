import java.io.*;
import java.util.Scanner;

/*
 *  바이트 단위 입출 및 출력 스트림
 *  ㄴ 바이트 단위 파일 복사 프로그램
 */

class B1_BytesFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("대상 파일 : ");
		String src = sc.nextLine(); //next는 단어 단위, nextLine는 줄 단위
		System.out.print("사본 이름 : ");
		String dst = sc.nextLine();
		
		try(InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dst)) {
			int data;
			while(true) {
				data = in.read(); // 파일로부터 1 바이트를 읽는다.
				if(data == -1) // 더이상 읽어 들일 데이터가 없다면,
					break;
				out.write(data); // 파일에 1바이트를 쓴다.
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
