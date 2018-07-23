public class Quiz9 {

	public static void main(String[] args) {
		
		int nNumber = 1;
		int sum = 0;
		
		System.out.println("1부터 100사이의 짝수는 ");

		do {
		      if((nNumber % 2 ) == 0)
		      {
		    	 System.out.println(nNumber + " ");
		    	 sum = sum + nNumber;
		      }
		           nNumber++;

		}while(nNumber <= 100);

		System.out.println("1 부터 100 사이 짝수의 합은 " + sum);



	}

}

