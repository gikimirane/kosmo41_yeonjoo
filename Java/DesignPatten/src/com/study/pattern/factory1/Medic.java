package com.study.pattern.factory1;

public class Medic implements Unit {

	public Medic() {
		System.out.println("메딕 생성!");
	}
	@Override
	public void move() {
		System.out.println("메딕 이동!");

	}

}
