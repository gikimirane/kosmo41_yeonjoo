import java.nio.file.*;
/*
 * 현재 디렉토리 정보의 출력 예
 */

class A2_CurrentDir {

	public static void main(String[] args) {
		Path cur = Paths.get(""); // 현재 디렉토리 정보 '상대 경로' 형태로 담긴 인스턴스 생성
		String cdir;
		
		if(cur.isAbsolute()) {
			System.out.println("댕댕이");
			cdir = cur.toString();
		} else {
			System.out.println("냥냥이");
			cdir = cur.toAbsolutePath().toString();
		}
		System.out.println("Current dir : " + cdir);

	}

}
