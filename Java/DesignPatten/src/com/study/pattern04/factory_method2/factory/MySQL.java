package com.study.pattern04.factory_method2.factory;

// A 'ConcreteProduct' class

public class MySQL extends Database {
	
	public MySQL() {
		name = "MySQL";
		rows = 20;
	}
	@Override
	public void connentDatabase() {
		System.out.println(name + "에 접속했습니다.");

	}

}
