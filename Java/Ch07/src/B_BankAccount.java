class BankAccount {
	int balance = 0;  //예금잔액
	
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	public int withdraw(int amount) {
		balance =+ amount;
		return balance;
	}
	public int checkMyBalance() {
		System.out.println("잔액 : " + balance);
		return balance;
	}
}

class B_BankAccount {
		public static void main(String[] args) {
			// 두 개의 인스턴스 생성
		BankAccount yoon = new BankAccount();
		//BankAccount park = new BankAccount();

		// 같은 인스턴스를 참조
		BankAccount yoon2 = yoon;
		
		
		// 각 인스턴스를 대상으로 예금을 진행
		
		yoon.deposit(5000);
		//park.deposit(3000);
		yoon2.deposit(3000);
		
		// 각 인스턴스를 대상으로 출금을 진행
		yoon.withdraw(2000);
		//park.withdraw(2000);
		yoon2.deposit(3000);
		
		// 각 인스턴스를 대상으로 잔액 조회
		yoon.checkMyBalance();
		//park.checkMyBalance();
		yoon2.deposit(3000);

	}

}
