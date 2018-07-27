public class This_Exam{
	
	String name = "빠담빠담";
	
	public void setName() {
	
		String name;
		name = "두근두근";
	
		System.out.println("name : " + name );
		System.out.println("this.name : " + this.name);
										//  ㄴ this : 자기자신을 의미하는 키워드 

	}
	
	
	public static void main(String[] args) {
		
		This_Exam t = new This_Exam();
		t.setName();
		
	}

} 
