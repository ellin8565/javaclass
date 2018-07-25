package bank;

public class Account {
	private String id;
	private String owner;
	private double balance;
	
	public Account() {}
	public Account(String id, String owner, int balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void interest() {
		balance*=1.1;
	}

	@Override
	public String toString() {
		return "Account 계좌=" + id + ", 성명=" + owner + ", 잔액=" + balance;
	}
	
}
