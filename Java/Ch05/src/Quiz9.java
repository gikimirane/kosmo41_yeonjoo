public class Quiz9 {

	public static void main(String[] args) {
		
		int nNumber = 1;
		int sum = 0;

		do {
		      if((nNumber % 2 ) == 0)
		      {
		System.out.print(nNumber);
		sum = sum + nNumber;
		      }
		           nNumber++;

		}while(nNumber <= 100);

		System.out.println("1부터 100 사이 짝수의 합은" + sum);



	}

}
