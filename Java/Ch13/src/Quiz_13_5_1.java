import java.util.Scanner;

public class Quiz_13_5_1 {

	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("단어를 입력해주세요");
		String word = s.next();
		
		String[] array_word = new String[word.length()];
		
		for(int i=0;i<array_word.length;i++)
		{ 
			array_word[i] = Character.toString(word.charAt(i));	
		}
		
		int nMax1 = array_word.length;
		int nMax2 = array_word.length/2; // 한문장을 반으로 끊어서 반씩 돌면서 확인
		
		for(int i=0; i<nMax2; i++)
			if(!array_word[i].equals(array_word[nMax1-1-i]))
			{
				System.out.println("회문이 아닙니다.");
				return;
			}
	
			System.out.println("회문입니다.");
	
	 }

}
