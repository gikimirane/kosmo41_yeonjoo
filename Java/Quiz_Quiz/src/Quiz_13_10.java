
public class Quiz_13_10 {

	public static void main(String[] args) {
		
		int[] ar = new int[4];
		
		ar[0] = 1;
		ar[1] = 2;
		ar[2] = 3;
		ar[3] = 4;
		
	
		
		System.out.print(ar[0]+"   "+ar[1]+"   "+ar[2]+"   "+ar[3] + "\n");
		System.out.print((ar[0]+4)+"   "+(ar[1]+4)+"   "+(ar[2]+4)+"   "+(ar[3]+4)+ "\n");
		System.out.print((ar[0]+8)+"  "+(ar[1]+8)+"  "+(ar[2]+8)+"  "+(ar[3]+8)+ "\n");
		System.out.print((ar[0]+12)+"  "+(ar[1]+12)+"  "+(ar[2]+12)+"  "+(ar[3]+12)+ "\n");
	
		System.out.println();

		System.out.print((ar[0]+12)+"   "+(ar[0]+8)+"   "+(ar[0]+4)+"   "+ar[0]+ "\n");
		System.out.print((ar[1]+12)+"   "+(ar[1]+8)+"   "+(ar[1]+4)+"   "+(ar[1])+ "\n");
		System.out.print((ar[2]+12)+"  "+(ar[2]+8)+"  "+(ar[2]+4)+"  "+(ar[2])+ "\n");
		System.out.print((ar[3]+12)+"  "+(ar[3]+8)+"  "+(ar[3]+4)+"  "+(ar[3])+ "\n");
	
		System.out.println();
		
		System.out.print((ar[3]+12)+"   "+(ar[2]+12)+"   "+(ar[1]+12)+"   "+(ar[0]+12)+"\n");
		System.out.print((ar[3]+8)+"  "+(ar[2]+8)+"  "+(ar[1]+8)+"  "+(ar[0]+8) + "\n");
		System.out.print((ar[3]+4)+"  "+(ar[2]+4)+"  "+(ar[1]+4)+"  "+(ar[0]+4)+ "\n");
		System.out.print(ar[3]+"  "+ar[2]+"  "+ar[1]+"  "+ar[0]+ "\n");
	
		System.out.println();
		
		System.out.print(ar[3]+"   "+(ar[3]+4)+"   "+(ar[3]+8)+"   "+(ar[3]+12)+"\n");
		System.out.print(ar[2]+"   "+(ar[2]+4)+"   "+(ar[2]+8)+"   "+(ar[2]+12)+"\n");
		System.out.print(ar[1]+"  "+(ar[1]+4)+"  "+(ar[1]+8)+"  "+(ar[1]+12)+"\n");
		System.out.print(ar[0]+"  "+(ar[0]+4)+"  "+(ar[0]+8)+"  "+(ar[0]+12)+"\n");
		
	}

}
