import java.nio.file.*;
/*
 *  Paths와 Path 클래스
 */

class A1_PathDemo {

	public static void main(String[] args) {
		Path pt1 = Paths.get("C:\\JavaStudy\\PathDemo.java");
		Path pt2 = pt1.getRoot();   // 루트 디렉토리 반환
		Path pt3 = pt1.getParent(); // 부모 디렉토리 반환
		Path pt4 = pt1.getFileName(); // 파일 이름 반환
	//   ㄴ Get 메소드 호출의 성공 여부는 해당 파일 또는 디렉토리의 존재여부와 상관 없다.
		
		System.out.println("Absolute : " + pt1);
		System.out.println("Root : " + pt2);
		System.out.println("Parent : " + pt3);
		System.out.println("File : " + pt4);

	}

}
