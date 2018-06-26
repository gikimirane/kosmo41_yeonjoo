
public class E2_TwoDimenArray {

	public static void main(String[] args) {
		int[][] arr = new int [3][4];
		
		int num = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j =0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num++;	
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		} 
		
		// 계단식 출력
		
		int[][] arr2 = {
				{11},
				{22, 33},
				{44, 55, 66}
		};
		
		for(int i = 0; i < arr2.length; i++) {
			for(int j =0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
