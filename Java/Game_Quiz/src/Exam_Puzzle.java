import java.util.Scanner;

public class Exam_Puzzle {

	public static void main(String[] args) {
		
		// 배열 출력, 방향키 설명
		
		System.out.println(" *** 재밌고 씬나는 퍼즐게임 *** ");
		System.out.println();
		
		char[][] arr = {{'1','2','3'},
						{'4','x','5'},
						{'6','7','8'}};
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}

		// 방향키 입력받기
		
		System.out.println("[Move] a:Left s:Right w:Up z:Down");
		System.out.println("[Exit] k:Exit");
		System.out.print("이동키를 입력하세요 : ");
		
		Scanner s = new Scanner(System.in);
		
		char user;
		user = s.nextLine().charAt(0);  //전체 문자열중에 첫번째 글자만 사용 하겠다
		
			
			if(user=='a') {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {

						if((j-1) >= 0 && arr[i][j-1]=='x'){
							arr[i][j-1] = arr[i][j];
							arr[i][j] = 'x';
						}
			
					}
				}
			}for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
				System.out.println();
						
			}if(user=='s') {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
		
						if((j+1)<= 2 && arr[i][j+1] =='x'){
							arr[i][j+1] = arr[i][j];
							arr[i][j] = 'x';
						}
					}
				}
			}for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
				System.out.println();
			}if(user=='w') {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if((i+1)<= 2 && arr[i+1][j] =='x'){
							arr[i+1][j] = arr[i][j];
							arr[i][j] = 'x';
						}
						
					}
				}
			}for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(arr[i][j] + "\t");
				}
				System.out.println();
				System.out.println();
				
			}if(user=='z') {
				for(int i=0; i<3; i++) {
						for(int j=0; j<3; j++) {
							if((i-1) >= 0 && arr[i-1][j]=='x'){
								arr[i-1][j] = arr[i][j];
								arr[i][j] = 'x';
							}						
						}
					}
			}for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						System.out.print(arr[i][j] + "\t");
						}
						System.out.println();
						System.out.println();
					} 
		
		}
	

}
		



