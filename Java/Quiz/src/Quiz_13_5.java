import java.util.Scanner;

public class Quiz_13_5 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("단어를 입력해 주세요");
		
		String word = s.next();
		
		String [] array_word = new String[word.length()];
		
		
		//문장의 Character를 하나씩 배열에 String으로 저장
		for(int i=0; i<word.length(); i++)
		{
			array_word[i] = Character.toString(word.charAt(i));
			
		}
		
		int wordMax = array_word.length;
		int halfMax = array_word.length / 2;
		
		for(int i=0; i<halfMax; i++) {
			
			if(!array_word[i].equals(array_word[wordMax - 1 - i])) {
				System.out.println("회문이 아닙니다!");
				System.out.println("다른 index : " + i + " : " +
				array_word[i] + " : " + array_word[wordMax - 1 -i]);
				
				return;
			}
		}
		
		System.out.println("회문입니다.");
	}

}
