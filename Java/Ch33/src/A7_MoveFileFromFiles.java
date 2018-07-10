import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/*
 *  파일 및 디렉토리의 '이동' 의 예
 */

public class A7_MoveFileFromFiles {

	public static void main(String[] args) throws IOException {
		Path src = Paths.get("D:\\only6hwa\\JavaStudy\\empty");
		Path dst = Paths.get("D:\\only6hwa\\JavaStudy\\empty2");
		
		// src가 지시하는 디렉토리를 dst가 지시하는 디렉토리로 '이동' >> 원본삭제
		Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);

	}

}
