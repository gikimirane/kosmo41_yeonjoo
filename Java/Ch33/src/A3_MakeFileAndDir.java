import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
 *  파일 및 디렉토리 생성의 예
 */

class A3_MakeFileAndDir {

	public static void main(String[] args) throws IOException {
//		Path fp = Paths.get("D:\\only6hwa\\JavaStudy\\empty.txt");
//		fp = Files.createFile(fp);  // 파일생성
		
//		Path dp1 = Paths.get("D:\\only6hwa\\JavaStudy\\empty");
//		dp1 = Files.createDirectory(dp1); // 디렉토리 생성
		
		Path dp2 = Paths.get("D:\\only6hwa\\JavaStudy2\\empty");
		dp2 = Files.createDirectories(dp2); // 경로의 모든 디렉토리 생성
		
//		System.out.println("File : " + fp);
//		System.out.println("Dir1 : " + dp1);
		System.out.println("Dir2 : " + dp2);
				

	}

}
