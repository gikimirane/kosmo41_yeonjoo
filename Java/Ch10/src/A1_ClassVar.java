class InstCnt {
	static int instNum = 0; //static으로 설정해놓을 경우 처음 1회에만 영향을 줌
	//int instNum = 0; static 설정을 해놓지 않으면 아래 변수들이 돌때마다 와서 영향을 받음
	
	InstCnt(){
		instNum++;
		System.out.println("인스턴스 생성: " + instNum);
	}
}
class A1_ClassVar {

	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
		
	}

}
