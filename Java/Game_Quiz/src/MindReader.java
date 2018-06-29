import java.util.Random;
import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) 
	{
		
		
		int max = 101;
		int min = 0;
		int avg;
		
		System.out.println("이름을 입력하세요");
		Scanner n = new Scanner(System.in);
		String name = n.nextLine();
		
		System.out.println(name + "님, 반갑습니다.");
		System.out.println("지금부터 0 ~ 100 사이의 숫자 1개를 생각하세요");
		System.out.println();
		System.out.println("제가 제시한 숫자가 " + name + "님이 생각한 숫자보다 작으면 ' h ' ");
		System.out.println("제가 제시한 숫자가 " + name + "님이 생각한 숫자보다 크면 ' l ' ");	
		System.out.println("제가 제시한 숫자가 " + name + "님이 생각한 숫자와 같으면 ' y ' 를 입력하세요");
		System.out.println();
		System.out.println("자! 그럼 '1번째' 도전!");
		 
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i <8; i++) 
		{ 
				avg = (min + max) / 2;
				System.out.println("당신이 생각한 숫자는 " + avg + " 입니까?");
		
				String str = s.nextLine();
				
				if(str.equalsIgnoreCase("h"))
				{
					min = avg;
					System.out.println ("아~ 아쉽네요! 자~ '" + (i+2) + "번째' 도전");
					continue;
				
				} else if(str.equalsIgnoreCase("l"))
				{
					max = avg;
					System.out.println ("아~ 아쉽네요! 자~ '" + (i+2) + "번째' 도전");
					continue;
				
				} else if(str.equalsIgnoreCase("y"))
				System.out.println ("짝짝짝 ! 진실은 언제나 하나!");
				break;
				
		}
			
	}

}

