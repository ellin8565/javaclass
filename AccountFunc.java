package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountFunc {

	ArrayList<Account> accounts = new ArrayList<>(); 
	Scanner scan = new Scanner(System.in);

	public void run() {
		int userSel = -1;
		while (userSel != 0) {
			print();
			userSel = Integer.parseInt(scan.nextLine());
			if (userSel == 1) {
				create();
			} else if (userSel == 2) {
				in();
			} else if (userSel == 3) {
				out();
			} else if (userSel == 4) {
				transfer();
			} else if (userSel == 5) {
				confirm();
			}else
				System.out.println("그런 메뉴 없어요");
		}
	}

	private void create() {

		System.out.println("계좌번호를 입력하세요.");
		String id = scan.nextLine();
		System.out.println("이름를 입력하세요.");
		String owner = scan.nextLine();
		System.out.println("금액를 입력하세요.");
		int balance = Integer.parseInt(scan.nextLine());
		Account account=new Account(id,owner,balance);
		accounts.add(account);
	}

	private Account SearchAccount(String id) {
		for (int i = 0; i < accounts.size(); i++) {
			if (id.equals(accounts.get(i).getId())) {
				return accounts.get(i);
			}
		}
		return null;
	}

	private void print() {
		System.out.println("1.계좌생성");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.이체");
		System.out.println("5.계좌정보확인");
		System.out.println("6.이자");
		System.out.println("0.종료");
	}

	private void in() {
		System.out.println("입금할 계좌번호를 입력하세요.");
		String id = scan.nextLine();
		System.out.println("입금할 금액를 입력하세요.");
		int money = Integer.parseInt(scan.nextLine());
		Account a = new Account();
		a = SearchAccount(id);
//		if (a != null) {
//			a.setBalance(a.getBalance() + money);
//			System.out.println("balance : " + a.getBalance());
//			System.out.println("성공적으로 입금되었습니다.");
//		} else
//			System.out.println("계좌번호가 존재하지 않습니다.");

		try {
			// 계좌번호 존재 확인
			if (a == null)
				throw new NoAccount();
			else {
				// yes=> 입금
				a.setBalance(a.getBalance() + money);
				System.out.println("balance : " + a.getBalance());
				System.out.println("성공적으로 출금되었습니다.");
			}
		} catch (NoAccount no) {
			no.printStackTrace();
			// no=>catch 예외처리(계좌번호가 없습니다.)
		}
	}

	private void out() {
		System.out.println("출금할 계좌번호를 입력하세요.");
		String id = scan.nextLine();
		System.out.println("출금할 금액를 입력하세요.");
		int money = Integer.parseInt(scan.nextLine());
		Account a = new Account();
		a = SearchAccount(id);
		try {
			// 계좌번호 존재 확인
			if (a == null)
				throw new NoAccount();
			else {
				// yes=> 출금
				try {
					if (money > a.getBalance())
						throw new NoMoney();
					else {
						a.setBalance(a.getBalance() - money);
						System.out.println("balance : " + a.getBalance());
						System.out.println("성공적으로 출금되었습니다.");
					}
				} catch (NoMoney n) {
					n.printStackTrace();
				}
			}
			// 출금(try)=> no 잔액이 부족
		} catch (NoAccount no) {
			no.printStackTrace();
			// no=>catch 예외처리(계좌번호가 없습니다.)
		}
	}

	private void transfer() {
		System.out.println("출금번호를 입력하세요.");
		String id = scan.nextLine();
		System.out.println("입금번호를 입력하세요.");
		String id2 = scan.nextLine();
		System.out.println("이체할 금액을 입력하세요.");
		int money = Integer.parseInt(scan.nextLine());
		Account a = new Account();
		Account b = new Account();
		a = SearchAccount(id);
		b = SearchAccount(id2);
		// 입금계좌
		if (a == null) {
			System.out.println("출금번호가 존재하지 않습니다.");
		}
		if (b == null) {
			System.out.println("입금번호가 존재하지 않습니다.");
		}
		if (a != null && b != null) {
			if (a.getBalance() > money) {
				a.setBalance(a.getBalance() - money);
				b.setBalance(b.getBalance() + money);
				System.out.println("성공적으로 이체가 되었습니다.");
			} else
				System.out.println("출금계좌에 잔액이 부족합니다.");
		}
	}

	private void confirm() {
		for (int i = 0; i < accounts.size(); i++)
			System.out.println(accounts.get(i));
	}
	private void interestAdd() {
	//        Account account = new Account();
		String id=scan.nextLine();
	    new Thread(new InterestThread(SearchAccount(id))).start();
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(SearchAccount(id).getBalance());
        }
         

	}

}
