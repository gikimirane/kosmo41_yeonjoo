package com.study.pattern02.strategy3;

public class Informix extends Database {

	public Informix() {
			name = "Informix";
			rows = 40;
		}

		@Override
		public void connnectDatabase() {
			System.out.println(name + "에 접속했습니다.");
			

	}

}
