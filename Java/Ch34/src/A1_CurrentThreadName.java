/*
 *  쓰레드의 이해와 쓰레드의 생성 방법
 *  쓰레드 - 프로그램 내에서 실행의 흐름을 이루는 최소의 단위
 *  main 메소드의 실행도 하나의 쓰레드에 의해 진행이된다.
 */
class A1_CurrentThreadName {

	public static void main(String[] args) {
		Thread ct = Thread.currentThread();
		String name = ct.getName(); //쓰레드의 이름을 반환
		System.out.println(name);

	}

}
