package com.study.pattern.factory1;

public class Marine implements Unit {

	public Marine() {
		System.out.println("마린 생성!");
	}  
	
	// 이름쓰고 컨트롤 + 스페이스 
	@Override
	public void move() {
		System.out.println("마린 이동!");

	}

}
