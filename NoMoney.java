package bank;

public class NoMoney extends Exception {
	public NoMoney() {
		System.out.println("잔액이 부족합니다.");
	}

}
