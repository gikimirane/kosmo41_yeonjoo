
public class Quiz13 {

	public static void main(String[] args) {
		System.out.println("������ ������");

		for(int j=1; j <=9; j++) {
		    for(int i=2; i<=9; i++) {
		System.out.print(i + " x " +  j + " = " + ( i* j));
		System.out.print("  ");
		if (i ==9)
		System.out.println(" | ");
		    }
		}

		System.out.println("������ ������");

			for(int i=2; i <=9; i++) {
				for(int j=1; j<=9; j++) {
					System.out.print(i + " x " +  j  + " = " + (i * j));
					System.out.print("   ");
					if (j ==9)
						System.out.print(" | ");
					}
					System.out.println("  ");
				}
			}
	}
