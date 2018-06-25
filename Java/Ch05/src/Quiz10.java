import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int num1 = 0, num2 = 0, sum = 0, add = 0;

		System.out.println("2 개의 정수를 입력하세요");
				num1 = s.nextInt();
				num2 = s.nextInt();

				if(num1 > num2) {
					for(add=num1; add >= num2; add--)
			{if(add = num2)
		{
		System.out.println(add);
		break;
		}
		sum = sum + add; 
		System.out.print(add + "+ ");
		}
		} else
		{  for(add = num1; add <= num2; add++)
		 { if(add = num2)
		{
			System.out.println(add);
		break;
		}
		sum = sum + add; 
			System.out.print(add + " + ");
			}
		}
		System.out.println(" = " + sum);


	}

}
