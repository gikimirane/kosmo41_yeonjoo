package zoo;

class Tiger{ 

//Tiger는 default(public X )로 선언되었으므로 동일 패키지 내에서만 인스턴스 생성이 가능
	
}

public class MyTiger {
	
	public void makeTiger1() {
		// Tiger와 같은 패키지로 묶여 있으니 Tiger 인스턴스 생성 가능
		Tiger hodol = new Tiger();

	}

}
