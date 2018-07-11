import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 *  컬렉션 인스턴스 동기화의 예
 */

class B5_SyncArrayList {
	
	public static List<Integer> lst = 
		Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 16; i++)
			lst.add(i);
		System.out.println(lst);
		
		Runnable task = () -> {
			ListIterator<Integer>itr = lst.listIterator();
			while(itr.hasNext())
				itr.set(itr.next() + 1);
		};
		
		
//		Runnable task = () -> {
//			synchronised(lst){
//				ListIterator<Integer> itr = lst.listIterator();
//			while(itr.hasNext())
//				itr.set(itr.next() + 1);
//			}
//		};
		
		ExecutorService exr = Executors.newFixedThreadPool(3);
		exr.submit(task);
		exr.submit(task);
		exr.submit(task);
		
		exr.shutdown();
		exr.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(lst);

	}

}
