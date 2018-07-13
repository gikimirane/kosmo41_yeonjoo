package com.study.pattern04.factory_method1;

import java.util.*;

import com.study.pattern04.factory_method1.factory.PatternAGenerator;
import com.study.pattern04.factory_method1.factory.PatternBGenerator;
import com.study.pattern04.factory_method1.factory.UnitGenerator;
import com.study.pattern04.factory_method1.unit.Unit;

public class Main {

	public static void main(String[] args) {
		// 타입이 두가지 있는 것만 알고 있음.
		UnitGenerator[] unitGenerators = new UnitGenerator[2];
		unitGenerators[0] = new PatternAGenerator();  //자식을 부모에게 대입
		unitGenerators[1] = new PatternBGenerator();
		
//		DoMakeType(unitGenerators[0]);
		DoMakeType(unitGenerators[1]);

	}
	
	public static void DoMakeType(UnitGenerator ug)
	{
		// 무엇이 만들어질지는 여기서는 알수 없음.
		ug.createUnits();
		
		List<Unit> units = ug.getUnits();
		for(Unit unit :units)
		{
			unit.attack();
		}
	}

}
