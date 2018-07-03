//
// 래퍼 클래스의 두가지 기능 ( 박싱과 언박싱 )

class B1_BoxingUnboxing {

	public static void main(String[] args) {
	
	// 인스턴스에 값을 감싸는 박싱 << int 와 double를 오브젝트 하나로 박싱
		
	Integer iObj = new Integer(10);
	Double dObj = new Double(3.14);
	
	System.out.println(iObj);
	System.out.println(dObj);
	System.out.println();
		
	//메소드 호출을 통한 언박싱  << 각각의 자료형 값으로 언박싱

	int num1 = iObj.intValue();
	double num2 = dObj.doubleValue();
	
	System.out.println(iObj);
	System.out.println(dObj);
	System.out.println();
	
	//래퍼 인스턴스 값의 증가 방법
	iObj = new Integer(iObj.intValue() + 10);
	dObj = new Double(dObj.doubleValue() + 1.2);
	
	System.out.println(iObj);
	System.out.println(dObj);
	
	}

}
