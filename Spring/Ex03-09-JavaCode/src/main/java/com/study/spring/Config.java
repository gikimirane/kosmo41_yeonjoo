package com.study.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Hello hello() {
		
		Hello hello1 = new Hello();
		hello1.setName("아이언맨");
		hello1.setNickname("닥터스트레인지");
		hello1.setPrinter(new PrinterA());
		
		return hello1;
	}
	
	@Bean(name="hello1")
	public Hello hello2() {
		
		return new Hello("아이언맨", "닥터스트레인지", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
	
}
