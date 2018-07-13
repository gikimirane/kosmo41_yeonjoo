package com.study.pattern02.strategy2;
/*
 * Strategy Pattern : 전략 패턴
 * ㄴ 여러 알고리즘을 하나의 추상적인 접근점을 만들어 
 *    접근점에서 알고리즘이 서로 교환 가능하도록 하는 패턴
 * ㄴ 구체적인 부분은 상이 하지만 접근점 밖의 내용은 언제든지 가감가능하여 연결 가능하게 함
 * ㄴ 하단의 예에서는 무기 추가는 'fire' 공통으로 언제든지 추가가능 
 */
public class Main {

	public static void main(String[] args) {
		GameCharacter character = new GameCharacter();
		character.fire();
		
		// 동일 목적 알고리즘의 선택 적용 문제
		// 전략적으로 무기를 선택
		character.setwebpon(new Arrow()); //fire에서 선택해서 적용함
		character.fire();
		
		character.setwebpon(new Bullet());
		character.fire();
		
		character.setwebpon(new Missile());
		character.fire();
		
		
	}

}
