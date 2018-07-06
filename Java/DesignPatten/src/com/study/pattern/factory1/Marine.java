package com.study.pattern.factory1;

/*
 * simple Factory Pattern 
 * * 클래스 만들 때 add 누르고 인터페이스 추가
 * 4. 안에 들어갈 정보들을 작성 
 */

public class Marine implements Unit {

	public Marine() {
		System.out.println("마린 생성!");
	}  
	
	// 이름쓰고 컨트롤 + 스페이스 >> constructor
	
	@Override
	public void move() {
		System.out.println("마린 이동!");

	}

}
