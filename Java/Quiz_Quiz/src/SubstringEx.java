public class SubstringEx {

	public static void main(String[] args) {
		
		/* 
		
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
		
		*/
		
		
		String str1 = "/to 이름 내용";
		if(str1.indexOf("/to") >= 0) {
			int nTmp1 = str1.indexOf(" ");
			String strTmp = str1.substring(nTmp1 + 1);
			
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 + 1);
			System.out.println(strTmp);
		}
		
		String c = "c a b";
		
		if(c.indexOf("c") >= 0) {
			int a = c.indexOf(" ");  //기준
			String b = c.substring(a + 1);
			
			a = b.indexOf(" ");
			b = b.substring(a + 1 ); // +1은 앞에 한칸을 자르기
			System.out.println(b);
		}
		

	}

}
