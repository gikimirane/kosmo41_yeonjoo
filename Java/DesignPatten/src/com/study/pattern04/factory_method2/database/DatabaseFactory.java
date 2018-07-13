package com.study.pattern04.factory_method2.database;

import com.study.pattern04.factory_method2.factory.Database;

enum DBType
{
	MySQL,
	Oracle,
	Informix
}

// The 'Creator' abstract class

public abstract class DatabaseFactory {

	//Factory Method
	public abstract Database setDatabase();
}
