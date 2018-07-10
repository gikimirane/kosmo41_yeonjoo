import java.io.*;
/*
 * 입출력 필터 스트림의 예  (데이터 출력)
 */

public class C2_DataFilterInputStream {

	public static void main(String[] args) {
		try(DataInputStream in =
				new DataInputStream(new FileInputStream("data.dat"))) {
			int num1 = in.readInt(); //int형 데이터를 꺼냄
			double num2 = in.readDouble(); //double형 데이터를 꺼냄
			System.out.println(num1);
			System.out.println(num2);
		}
		catch(IOException e) { 
			e.printStackTrace();
		}
	}

}
