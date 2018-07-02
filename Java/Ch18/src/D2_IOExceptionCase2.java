import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//
	// Exception을 상속하는 예외는 반드시 처리를 해야 한다.
	//  ㄴ 그렇지 않으면, 컴파일 오류로 이어진다.

	public class D2_IOExceptionCase2 {

		public static void main(String[] args) {
			Path file = Paths.get("D:\\only6hwa\\study2\\simple.txt");
			BufferedWriter writer = null;
			
			try {
				writer = Files.newBufferedWriter(file);  //IOException 발생 가능
				writer.write('A');   //IOException 발생 가능
				writer.write('Z');   //IOException 발생 가능
				
				if(writer != null)
					writer.close();  //IOException 발생 가능
			}

			catch(IOException e) {
				e.printStackTrace();  
			}
		}

	}
