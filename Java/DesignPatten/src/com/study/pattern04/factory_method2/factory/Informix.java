package com.study.pattern04.factory_method2.factory;

//C 'ConcreteProduct' class

public class Informix extends Database {

	public Informix() {
		name = "Informix";
		rows = 20;
	}
	@Override
	public void connentDatabase() {
		System.out.println(name + "에 접속했습니다.");
	}
}
