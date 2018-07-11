import java.util.concurrent.*;


/*
 * Callable & Future 관련 예 
 */

class B3_CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> task = () -> {
			int sum = 0;
			for(int i = 0; i < 10; i++)
				sum += i;
			return sum;
		};
		
		ExecutorService exr = Executors.newSingleThreadExecutor();
		Future<Integer> fur = exr.submit(task);
		
		Integer r = fur.get();  //쓰레드의 반환 값 획득
		System.out.println("result : " + r);
		exr.shutdown();
	}

}
