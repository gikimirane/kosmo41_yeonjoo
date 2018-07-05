public class SubstringEx {

	public static void main(String[] args) {
		
		// 1.마지막 3글자만 출력
		String str1 = "ABCDEFG";
		String result1 = str1.substring(str1.length()-3,str1.length());
		System.out.println(result1);
		
		// 1 ~ 3번째까지 글자 자르기
		String str2 = "ABCDEFG";
		String result2 = str1.substring(3);
		System.out.println(result2);
		
		// 특정문자 포함, 이전의 문자열 제거
		String str3 = "AB:CD:DEFGH";
		int num2 = str3.indexOf(":"); // 처음부터 (기준이 되는 문자)
		String result3 = str3.substring(num2+1);
		System.out.println(result3);
		
		// 특정문자 포함, 이전의 문자열 제거 (거꾸로)
		String str4 = "AB:CD:DEFGH";
		int num3 = str4.lastIndexOf(":"); // 마지막부터 (기준이 되는 문자)
		String result4 = str4.substring(num3+1);
		System.out.println(result4);
	}

}
