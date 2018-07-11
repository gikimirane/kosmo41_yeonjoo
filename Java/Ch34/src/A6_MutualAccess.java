/*
 *  쓰레드의 메모리 접근 방식과 그에 따른 문제점
 *  ㄴ 공유되는 변수의 값이 동시에 바뀌거나 하여 원하는 값을 얻지 못할 수도 있음.
 */
class Counter {
	int count = 0; //공유되는 변수
	
	public void increment() {
		count++;   //첫번쨰 쓰레드에 의해 실행
	}
	public void decrement() {
		count--;   //두번째 쓰레드에 의해 실행
	}
	public int getCount() {
		return count;
	}
}

class A6_MutualAccess {
	public static Counter cnt = new Counter();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.increment();  //값을 1 증가
		};
		
		Runnable task2 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.decrement();  //값을 1 감소
		};
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
		t1.join(); // t1이 참조하는 쓰레드의 종료를 기다림
		t2.join(); // t2가 참조하는 쓰레드의 종료를 기다림
		
		// 쓰레드가 종료되면 출력을 진행함. 위 join의 영향
		System.out.println(cnt.getCount());

	}

}
