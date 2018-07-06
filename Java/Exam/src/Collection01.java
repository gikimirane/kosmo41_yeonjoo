import java.util.*;

// 컬렉션 클래스
// ㄴ 컬렉션 프레임워크에 속하는 인터페이스를 
//    구현한 클래스를 컬렉션 클래스(collection class)라고 합니다.

public class Collection01 {

    public static void main(String[] args) {

        // 리스트 생성
    	
        ArrayList<String> arrList = new ArrayList<String>();

 

        // 리스트에 요소의 저장

        arrList.add("넷");

        arrList.add("둘");

        arrList.add("셋");

        arrList.add("하나");

 

        // 리스트 요소의 출력

        for(int i = 0; i < arrList.size(); i++) {

            System.out.println(arrList.get(i));

        }

    }

}