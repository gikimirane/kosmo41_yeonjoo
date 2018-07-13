package com.study.pattern04.factory_method1.factory;

import java.util.*;

import com.study.pattern04.factory_method1.unit.Unit;

// The 'Creator' abstract class
 
public abstract class UnitGenerator {

	public List<Unit> units = new ArrayList<Unit>();
	
	public List<Unit> getUnits()
	{
		return units;
	}
	// Factory Method
	public abstract void createUnits();
	

}
