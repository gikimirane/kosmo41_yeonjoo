import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/*
 * synchronized를 대신하는 ReentrantLock
 * ReentrantLock : 동기화된 메소드와 문장을 사용하여 액세스 할 수 있는 
 * 암시적인 모니터 잠금 기능과 같은 기본적인 동작과 의미를 가진 
 * reentrant 상호 간의 상호 배제된 상호 배제 잠금 기능(명시적 동기화)
 * " synchronized는 암묵적이고, ReentrantLock은 명시적 "
 */

class Counter4 {
	int count = 0; 
	ReentrantLock critic0bj = new ReentrantLock();
	
	public void increment() { 
		critic0bj.lock(); // 문을 잠근다.(동기화의 시작)
		
		try {  			  // 한 쓰레드에 의해서만 실행되는 영역
			count++;      // 문을 연다. (동기화의 끝지점)
		} finally {
			critic0bj.unlock();
		} 
	}
	public void decrement() {
		critic0bj.lock();
		
		try {
			count--; 
		} finally {
			critic0bj.unlock();
		} 
	}

	public int getCount() {
		return count;
	}
}

class B4_MutualAccessReentrantLock {
	public static Counter4 cnt = new Counter4();
	
	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.increment();  //값을 1 증가
		};
		
		Runnable task2 = () -> {
			for(int i = 0; i < 1000; i++)
				cnt.decrement();  //값을 1 감소
		};
		
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		
		System.out.println(cnt.getCount());

	}

}
