import java.io.*;
/*
 * ObjectOutputStream 예제 (파일생성)
 */

public class E2_ObjectOutputStream {

	public static void main(String[] args) {
		E1_SBox box1 = new E1_SBox("Robot");
		E1_SBox box2 = new E1_SBox("Strawberry");
		
		try(ObjectOutputStream oo = 
				new ObjectOutputStream(new FileOutputStream("Object.bin"))) {
			oo.writeObject(box1); // box1이 참조하는 인스턴스 저장
			oo.writeObject(box2); // box2이 참조하는 인스턴스 저장
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
