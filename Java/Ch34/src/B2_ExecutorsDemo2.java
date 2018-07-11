import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 *  쓰레드 풀 기반의 예제2
 *  ㄴ 쓰레드 풀 : 미리 쓰레드를 할당시켜 놓는기법
 *  ㄴ 쓰레드가 너무 늘어나는 것을 막기위해 (증폭을 제어)
 */

class B2_ExecutorsDemo2 {

	public static void main(String[] args) {
		Runnable task1 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (5 + 7));
		};
		Runnable task2 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (7 - 5));
		};
		ExecutorService exr = Executors.newFixedThreadPool(2);
		exr.submit(task1);
		exr.submit(task2);
		exr.submit(() -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (5 * 7));
		});
	
	}

}
