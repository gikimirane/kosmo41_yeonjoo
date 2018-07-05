import java.util.*;
//
// hashCode 메소드의 다양한 정의의 예
//

class Car {
	private String model;
	private String color;
	
	public Car(String m, String c) {
		model = m;
		color = c;
	}
	
	@Override
	public String toString() {
		return model + " : " + color;
	}
	
	@Override
	public int hashCode() {
		return(model.hashCode() + color.hashCode()) / 2;
		// 모든 인스턴스 변수의 정보를 다 반영하여 해쉬 값을 얻으려는 노력
		// 결과적으로 더 세밀하게 나뉘고, 따라서 그만큼 탐색 속도가 높아짐
	}
/* @Override
 * public int hashCode() {
 * 		return java.util.Object.hash(model,color);
 * }
 */
	@Override
	public boolean equals(Object obj) {
		String m = ((Car)obj).model;
		String c = ((Car)obj).color;
		
		if(model.equals(m) && color.equals(c))
			return true;
		else
			return false;
	}
}
class B4_HowHashCode {

	public static void main(String[] args) {
		HashSet<Car> set = new HashSet<>();
		set.add(new Car("HY_MD_301","RED"));
		set.add(new Car("HY_MD_301","BLACK"));
		set.add(new Car("HY_MD_302","RED"));
		set.add(new Car("HY_MD_302","WHITE"));
		set.add(new Car("HY_MD_301","BLACK")); //중복된 내용임으로 제외

		System.out.println("인스턴스 수: " + set.size());
		
		for(Car car : set)
			System.out.println(car.toString() + '\t');
	}

}
