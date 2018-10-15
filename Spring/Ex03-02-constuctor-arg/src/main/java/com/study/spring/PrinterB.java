package com.study.spring;

public class PrinterB implements Printer {
	public void print(String message) {
		System.out.print("Printer B : "+message);
	}
}
