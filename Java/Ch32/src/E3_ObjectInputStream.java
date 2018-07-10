import java.io.*;
/*
 * ObjectOutputStream 예제 (출력)
 */

public class E3_ObjectInputStream {

	public static void main(String[] args) {
		
		try(ObjectInputStream oi = 
				new ObjectInputStream(new FileInputStream("Object.bin"))) {
			
			E1_SBox box1 = (E1_SBox) oi.readObject(); //인스턴스 복원
			System.out.println(box1.get());
			E1_SBox box2 = (E1_SBox) oi.readObject(); //인스턴스 복원
			System.out.println(box2.get());
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
