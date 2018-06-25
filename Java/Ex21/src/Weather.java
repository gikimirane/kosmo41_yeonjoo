class Wdata
{
	int month;
	int day;
	String sky;	
}

 // 데이터(필드)와 처리동작(메서드)을 하나로 모아놓은 것을 class 라고 한다.

class Weather
{
	public static void main(String[] args) 
	{
		Wdata today = new Wdata();
		today.month = 10;
		today.day = 5;
		today.sky = "맑음";
		
		System.out.println(today.month + "월 " +
						   today.day + "일 " +
						   today.sky);
	}

}
