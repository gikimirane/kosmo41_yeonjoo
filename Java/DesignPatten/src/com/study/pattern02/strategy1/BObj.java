package com.study.pattern02.strategy1;

public class BObj {
	
// 4. 인터페이스를 통한 기능구현(Delegate
	
	AInterface ainter;
	
	public BObj() {
		ainter = new AImplement(); //자식을 부모에게 대입
	}

	public void SomeFunc() {
		
		//3. 기능 구현을 위임 - Delegate (다음 기능이 필요합니다~ 만들어주세요~)
//		System.out.println("AAA");
//		System.out.println("AAA");
//		System.out.println("AAA");

		// Delegate 사용
		ainter.funcA();
		ainter.funcA();
		ainter.funcA();
	}
	
}
