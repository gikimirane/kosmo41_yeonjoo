
public class Quiz12 {

	public static void main(String[] args) {
		int nNumber = 1;
		int sum = 0;

		do {
		      if (nNumber == 1000) {
		System.out.print(nNumber);
		sum = sum + nNumber;

		break;

		      }
		System.out.print(nNumber + " + " );
		sum = sum + nNumber;
		            
		            nNumber++;

		}while(nNumber <= 1000);

		System.out.println(" = " + sum);


	}

}
