import java.util.*;
	
/*
 * 매개변수가 없는 람다식
 */

interface Generator {
		int rand(); //매개변수 없는 메소드
	}

class A6_NoParamAndReturn {

	public static void main(String[] args) {
		Generator gen = () -> {   //파라미터가 없을 때 씀
			Random rand = new Random();
				return rand.nextInt(50);
			};
			
			System.out.println(gen.rand());

		}

	}
