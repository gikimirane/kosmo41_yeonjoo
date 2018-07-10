import java.io.*;
import java.util.Scanner;
/*
 *  버퍼링 기능을 제공하는 필터 스트림
 *  ㄴ 바이트 단위로 복사가 진행되지만, 버퍼링 되므로 속도는 빠르다.
 */

class C3_BufferedStreamFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("대상 파일 : ");
		String src = sc.nextLine(); 
		System.out.print("사본 이름 : ");
		String dst = sc.nextLine();
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src)) ;
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) { 
			int data;
			while(true) {
				data = in.read(); 
				if(data == -1) 
					break;
				out.write(data); 
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
