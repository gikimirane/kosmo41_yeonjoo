package com.study.pattern03.strategy2;

public class GameCharacter {
	
	// 접근점 (인터페이스가 각종무기의 단일 통로)
	private Weapon weapon;
	
	// 무기 교환이 가능하도록 함
	public void setwebpon(Weapon weapon) {
		
		this.weapon = weapon;
	}
	
	// 기능사용 (기능 위임)
	public void fire() {
		if(weapon == null) {
			System.out.println("무기를 먼저 착용하세요");
		} else {
			weapon.Shoot(); //델리게이트 함수를 호출
		}
	
	}
}
