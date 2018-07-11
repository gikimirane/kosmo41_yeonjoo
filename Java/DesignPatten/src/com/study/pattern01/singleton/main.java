package com.study.pattern01.singleton;
/*
 * singleton pattern은 인스턴스가 사용될 때에 똑같은 인스턴스를 만들어 내는 것이 아니라, 
 * 동일 인스턴스를 사용하게끔 하는 것이 기본 전략이다. 
 * 프로그램상에서 동일한 커넥션 객체를 만든다던지, 
 * 하나만 사용되야하는 객체를 만들때 매우 유용하다. 
 * 
 * “오직 한 개의 클래스 인스턴스만을 갖도록 보장하고, 이에 대한 전역적인 접근점을 제공”
 */
public class main {

	public static void main(String[] args) {

		ClassOne class1 = new ClassOne();
		ClassTwo class2 = new ClassTwo();

	}

}
