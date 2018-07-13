package com.study.pattern04.factory_method1.unit;

enum UnitType {
	Marine,
	Firebat
}

// <Summary>
//
// </Summary>

public abstract class Unit {

	protected UnitType type;
	protected String name;
	protected int hp;
	protected int exp;
	public abstract void attack();
}
