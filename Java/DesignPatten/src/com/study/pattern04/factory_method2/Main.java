package com.study.pattern04.factory_method2;

import com.study.pattern04.factory_method2.database.DatabaseFactory;
import com.study.pattern04.factory_method2.database.DatabaseFactoryUse;
import com.study.pattern04.factory_method2.factory.Database;

public class Main {

	public static void main(String[] args) {
		DatabaseFactory factory = new DatabaseFactoryUse();
		
		// 어떤 데이터베이스가 사용될지 여기서는 모른다.
		// 팩토리 메서드에서 제공되는 데이터베이스를 그냥 사용한다.
		Database db = factory.setDatabase();
		
		// 데이터 베이스에 접속
		db.connentDatabase();
		
		// 접속된 데이터베이스를 이용해 업무처리를 한다.
		db.insertData();
		db.selectData();

	}

}

// 팩토리에 있는 메서드만 사용한다.