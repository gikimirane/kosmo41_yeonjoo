class Box {
	private String conts;
	
	Box(String cont) { this.conts = cont; }
	public String tostring () {
		return conts;
	}
}


class A2_ArrayIsInstance2 {
	public static void main(String[] args) {
		Box[] ar = new Box[5]; //길이가 5인 Box형 1차원 배열의 생성
		System.out.println("length : " + ar.length);  //length : 5
	}

}

// 값의 저장과 참조의 예