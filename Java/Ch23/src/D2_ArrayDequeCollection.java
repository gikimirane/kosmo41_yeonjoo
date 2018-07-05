import java.util.*;
//
// Deque을 기준으로 스택을 구현
// ㄴ Deque<String> deq = new ArrayDeque<>();

class D2_ArrayDequeCollection {
	public static void main(String[] args) {
		Deque<String> deq = new ArrayDeque<>();
		
		//앞으로 넣고
		deq.offerFirst("1.Box");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		//앞으로 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println("-------");
		
		//뒤로 넣고
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
				
		//뒤로 꺼내기
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		
		System.out.println("-------");
		
		//뒤로 넣고
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		//앞으로 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		System.out.println("-------");
				
	}

}

// 다음 문장도 구성 가능
// Deque<String> deq = new LinkedList<>();

// LinkedList<E> 가 구현하는 인터페이스들
// Deque<E> , List<E> , Queue<E>
