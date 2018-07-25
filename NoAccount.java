package bank;

public class NoAccount extends Exception {
	public NoAccount() {
		System.out.println("계좌가 없습니다.");
	}
}
