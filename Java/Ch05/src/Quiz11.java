import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) 
	{
		
		int Inputnum = 0;
		int Fact = 1;

		Scanner s = new Scanner(System.in);

		System.out.println("1 개의 숫자를 입력하세요");

		Inputnum = s.nextInt();

		while(Inputnum>0)
			{
				if(Inputnum == 1) {
					System.out.print(Inputnum);
					break;
				}
				System.out.print(Inputnum);
				System.out.print( "x" );
				Fact = Fact * Inputnum;
				Inputnum--;
			}
			System.out.println("=" + Fact);

	}

}
