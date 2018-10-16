package com.study.spring;

public class Hello {
	
	private String name;
	private String nickname;
	private Printer printer;
	
	public Hello() {};
	
	// 파라미터가 있는 생성자를 사용할 경우 디폴트 생성자가 자동으로 만들어지지 않는다.
	// 그러므로 new Hello() 같은 디폴트 생성자를 사용하기 위해서는 하단처럼 만들어야 함
	public Hello(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello "+name+" : "+nickname;
	}
	public void print() {
		printer.print(sayHello());
	}
	
}


