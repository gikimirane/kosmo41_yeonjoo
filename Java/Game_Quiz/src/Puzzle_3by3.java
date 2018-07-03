import java.util.Scanner;

public class Puzzle_3by3 {

	public static void main(String[] args) {
	
		int[][] puzzle = { {1,2,3},
				           {4,0,6},
					       {7,8,9} };
		
		puzzlePrint(puzzle);
			
		int x = 0;
		int y = 0;
		int a = 0;
		
		int [][] puzzle2 = new int [3][3];
	
	    Scanner s = new Scanner(System.in);
		
		int[] num = new int[1];
		
			System.out.println("[ Move ] 1:Left 2:Right 3:Up 4:Down");
			System.out.println("[ Exit ] 0:Exit ");
			
			int user = s.nextInt();
			num[a] = user;

	while(true) {
		
		if(user==1) {
		puzzle2[x][y] = puzzle[1-x][y];
		System.out.printf("%2d",puzzle[x][y]);
		} else if(user==2) {
			puzzle2[x][y] = puzzle[x][1-y];
			System.out.printf("%2d",puzzle[x][y]);
		}
	}
	}
	

	public static void puzzlePrint(int[][] puzzle) {
		for (int i = 0; i <3; i++) {
			for(int j = 0; j <3; j++) {
				System.out.printf("%2d",puzzle[i][j]);
			}
			System.out.println();
		}
		
	}

}
