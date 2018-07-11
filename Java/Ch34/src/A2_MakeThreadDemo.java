/*
 *  쓰레드를 생성하는 방법
 *  ㄴ Runnable을 구현한 인스턴스 생성 > Thread 인스턴스 생성 > start메소드 호출
 */ 

class A2_MakeThreadDemo {

	public static void main(String[] args) {
		Runnable task = () -> { // 쓰레드가 실행하게 할 내용
			try {
				Thread.sleep(3000);  // 3초간 쉰 후에 동작하라는 뜻
			} catch (Exception e) {
				
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (n1 + n2));
		};
		
		Thread t = new Thread(task);
		t.start(); // 쓰레드 생성 및 실행
		System.out.println("End " + Thread.currentThread().getName());
	}

}

// start를 부르면 void run()을 찾아서 실행 시켜줌
// 위에 공식은 람다식이기 때문에 void run()이 생략 됨

