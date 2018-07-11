/*
 *  동기화(Synchronization)블록
 *  ㄴ 공유객체가 가진 메소드를 동시에 호출 되지 않도록 하는 방법
 *  ㄴ synchronized를 메소드에 붙혀서 사용 할 경우, 메소드의 코드가 길어지면, 
 *     마지막에 대기하는 쓰레드가 너무 오래 기다리는것을 막기위해서 
 *     메소드에 synchronized를 붙이지 않고, 
 *     문제가 있을것 같은 부분만 synchronized블록을 사용한다.
 */
class Counter2 {
	int count = 0; //공유되는 변수
	
	public void increment() {
		synchronized(this) { // synchronized(this) << 동기화 블록
		count++;   //첫번쨰 쓰레드에 의해 실행
		}
	}
	public void decrement() {
		synchronized(this) {
		count--;   //두번째 쓰레드에 의해 실행
		}
	}
	public int getCount() {
		return count;
	}
}

class A8_MutualAccessSyncBlock {
	public static Counter2 cnt = new Counter2();
	
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


