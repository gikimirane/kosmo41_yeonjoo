package com.study.pattern04.factory_method2.database;

import com.study.pattern04.factory_method2.factory.Database;
import com.study.pattern04.factory_method2.factory.MySQL;
import com.study.pattern04.factory_method2.factory.Oracle;

public class DatabaseFactoryUse extends DatabaseFactory {

	// 이번에 사용할 데이터베이스는 Oracle이다.
	// 데이터베이스 변경 시 여기서 타입을 변경한다.
	public DBType dbType = DBType.MySQL;
	
	@Override
	public Database setDatabase() {
	    // 회사 사정에 의해 어떤 데이터베이스를 다시 사용할지 모름
		// 그래서 구축한 정보를 지우지 않고 재사용시를 대비
		
		if(dbType == DBType.MySQL)
		{
			System.out.println("MySQL use...");
			return new MySQL();
		}
		else if (dbType == DBType.Oracle)
		{
			System.out.println("Oracle use...");
			return new Oracle();
		}
		else if (dbType == DBType.Informix)
		{
			System.out.println("Informix...");
			return new Oracle();
		}
		
		return null;
	}

}
