import java.util.Scanner;

public class Quiz_13_5 {

	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("단어를 입력해주세요");
		
		String word = s.next();

		String[] array_word = new String[word.length()]; // 스트링을 담을 배열
		
		for(int i=0;i<array_word.length;i++)
		{ 
			array_word[i] = Character.toString(word.charAt(i));	
		
			int str1 = 0;
			int str2 = array_word.length-1;
			
			if(str1 != str2)
			{
					System.out.println("회문이아닙니다.");
					break;
			    
			}
			if(str1 == str2)
			{
				    System.out.println("...");
			}
			

		 }
	}
			

		// for(int i=0;i<array_word.length;i++)
		// {
	    // System.out.println(array_word[i]);
		

		
	}

