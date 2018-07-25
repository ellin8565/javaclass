#DAY07
___

###VCM
>모델-뷰-컨트롤러(Model–View–Controller, MVC)는 소프트웨어 공학에서 사용되는 소프트웨어 디자인 패턴.
>- View : 모델로 부터 값을 가져와 사용자에게 보여줌.
웹브라우저로 제공(html-틀, css-꾸밈, java script-동작)
>- Controller : 사용자의 요구 구현
>- Model :데이터 저장

>+데이터베이스
DBMS : 데이터 베이스 관리 프로그램
ex)Oracle


###상속(inheritance)

>기존의 클래스를 재사용하여 새로운 클래스 작성
>상속 관계는 IS-A 관계(참고 : circle-point는 HAS-A관계)
>- 형태 : class AAA extends BBB
>- 자식클래스가 객체화 될 때는 부모클래스이 기본생성자를 묵시적으로 호출
>- 부모 클래스가 기본생성자가 없다면 자식클래스의 생성자 첫 줄에서 부모클래스 생성자 명시적으로 호출해줘야함.
>- 부모클래스&자식클래스, 상위 클래스&하위 클래스

---
	1)
    class Tv {
	boolean power;
	int channel;

	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
	}
	class CaptionTv extends Tv{
	boolean caption;
	void displayCaption(String text) {
		if(caption) { //캡션 상태가 true일 때만 text 출력
			System.out.println(text);
		}
	}
	}
	public class Test {
	public static void main(String[] args) {
		CaptionTv ctv=new CaptionTv();
		ctv.channel=10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello World");
		ctv.caption=true;
		ctv.displayCaption("Hello World");
	}
	}
---
###오버라이딩(overriding)
>상위 클래스로부터 상속받은 메서드의 내용을 변경하는 것
>- 조건 : 이름, 매개변수, 반환타입이 같아야함.
>ex)println(toString) : 모든 객체는 object 클래스를 상속하고 있으므로 toString 보유(주소 출력), 자식 클래스에서 내용을 다르게 정의하면 그 내용 출력
>

###Object 클래스
>모든 클래스의 상속계층도의 최상위에 있음.
>모든 클래스는 자동적으로 Object클래스로부터 상속받음.
 

---
	2)
    class Parent {
	int data = 100;;

	public void print() {
		System.out.println("Parent의 data :" + data);
	}
	}
	class Child extends Parent {
	int data = 200;

	public void print() {
		int data = 300;
		System.out.println("print 지역변수 data :" + data); //가까운 것 출력
		System.out.println("this.data :" + this.data);
		System.out.println("super.data(부모 객체) :" + super.data);
	}
	// 오버라이딩 : 부모클래스에 있지만 자식 클래스도 같은 이름의 멤버변수, 함수를 만듦
	}

	public class Test {
	public static void main(String[] args) {
		Child c = new Child();
		c.print();
	}
	}
    //출력결과
    지역변수 data :300
	this.data :200
	super.data(부모 객체) :100
    

	3) 자식클래스가 객체화 될 때는 부모클래스의 '기본 생성자'를 묵시적으로 호출
    class Parent {
	int data = 100;;
	public Parent() {
		System.out.println("Parent 생성자 호출");
	}
	public Parent(String msg) {
		System.out.println(msg +" 생성자 호출");
	}
	public void print() {
		System.out.println("Parent의 data :" + data);
	}
	}

	class Child extends Parent {
	int data = 200;
	public Child() {
		//자식 클래스이 생성자에는 묵시적으로 부모 클래스의 기본생성자를 호출하는 코드가 숨어있음.
		System.out.println("Child 생성자 호출");
	}
	public void print() {
		int data = 300;
		System.out.println("print 지역변수 data :" + data); //가까운 것 출력
		System.out.println("this.data :" + this.data);
		System.out.println("super.data(부모 객체) :" + super.data);
	}
	}

	public class Test {
	public static void main(String[] args) {
		Child c = new Child();
		//c.print();
	}
	}
	//출력결과
    Parent 생성자 호출
	Child 생성자 호출
    
    3-1)
	class Parent {
	int data = 100;;
	//public Parent() {
	//	System.out.println("Parent 생성자 호출");
	//}
	public Parent(String msg) {
		System.out.println(msg +" 생성자 호출");
	}
	public void print() {
		System.out.println("Parent의 data :" + data);
	}
	}

	class Child extends Parent {
	int data = 200;
	public Child() {
		//super();=>명시적 부모클래스의 기본생성자 호출
		super("HELLO"); //이 라인 주석 처리시 에러 발생=>b.c 기본생성자 없음.
		System.out.println("Child 생성자 호출");
	}
	public void print() {
		int data = 300;
		System.out.println("print 지역변수 data :" + data); //가까운 것 출력
		System.out.println("this.data :" + this.data);
		System.out.println("super.data(부모 객체) :" + super.data);
	}
	}

	public class Test {
	public static void main(String[] args) {
		Child c = new Child();
	}
	}
	//출력결과
    HELLO 생성자 호출
	Child 생성자 호출

---

###접근지정자
> private : 부모 클래스의 private멤버는 접근불가

---
	4)
	public class Em {
	public String name;
	private int RRN;
	protected int salary;

	public int getSalary() {
	return salary;
	}

	public void setSalary(int salary) {
	this.salary = salary;
	}
	}
    public class Manager extends Em{
	private int bonus;

	public int getSalary() {
	return salary+bonus;
	}
	private void setSalary(int salary) { //에러
	//Em setSalary는 protected
	//더 좁은 범위로 오버라이딩 할 수 없음.
	super.salary=salary;
	}
	public void setRRN(int rrn) { //에러 private는 서브클래스에서 접근 불가
	RRN=rrn;
	}
	}
    
---

###종단 클래스와 종단 메소드
>final이 붙은 메소드는 오버라이딩 불가
>


###package& import
>package : 클래스는 패캐지로 구분,클래스들을 묶어 놓은 것
>- 하나의 패키지에 같은 이름의 클래스가 두개 있을 수 없음.
>- 관련된 클래스들을 쉽게 파악
>- 형식 : package bunsiness;
>- ex01, ex01.test=>ex01 패키지, ex01.test가 이름인 동시에 ex01속 패키지
>- 하나의 java파일에는 하나의 클래스 권장.
>
>import : 다른 패키지의 클래스를 사용하기 위해 
>- 형식 : import 패키지명.클래스명; or import 패키지명.*;


----
	5)
    import java.text.SimpleDateFormat;
	import java.util.Date;

	public class ImportTest {
	public static void main(String[] args) {
	Date today=new Date(); //Date 클래스 : 한 시점의 시간 저장
	
	SimpleDateFormat date=new SimpleDateFormat("yyyy/MM/dd");
	//형변환, 서식화된 포맷으로
	SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss a");
	SimpleDateFormat time1 = new SimpleDateFormat("hh:mm:ss a");
	 System.out.println("오늘 날짜는 "+ date.format(today));
	 System.out.println("현재 시간은 "+time.format(today));
	 System.out.println("현재 시간은 "+time1.format(today));
	}
	}
    //출력결과
    오늘 날짜는 2018/07/11
	현재 시간은 13:21:22 오후
	현재 시간은 01:21:22 오후

###Wrapper 클래스
>기초 자료형을 객체로 포장시켜주는 클래스
>- ex) Byte, Short, Integer, Long, Double, Character...

	6)
    import java.util.Scanner;

	public class Wrapper {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		String b = scan.nextLine();

		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		System.out.println(num1 + num2);

	}
	}

###StringTokenizer
>문자열을 분석하여 토큰으로 분리시켜 주는 기능 제공

---
	7)
    import java.util.StringTokenizer;

	public class Tokenizer {
	public static void main(String[] args) {
	StringTokenizer st=new StringTokenizer("Will java change my life?");
    StringTokenizer st=new StringTokenizer("Will java change my life?","a");
	while (st.hasMoreTokens()) {
		System.out.println(st.nextToken());		}
	}
	}
    //출력결과
    Will
	java
	change
	my
	life?

    7-1)
    import java.util.Scanner;
	import java.util.StringTokenizer;

	public class Tokenizer {
	public static void main(String[] args) {
	int sum=0;
	Scanner scan= new Scanner(System.in);
	System.out.println("수식입력");
	String sum1 =scan.nextLine();
	StringTokenizer st=new StringTokenizer(sum1,"+");
	//String num1=st.nextToken();
	//String num2=st.nextToken();
	//int a=Integer.parseInt(num1)+Integer.parseInt(num2);
	//System.out.println(a);
	while (st.hasMoreTokens()) {
		int a=Integer.parseInt(st.nextToken());
		sum+=a;
	}
	System.out.println(sum);
	}
	}
	//출력결과
    수식입력
	1+2
	3
---
###example :계좌 만들기
>1.계좌생성
2.입금
3.출금
4.이체
5.정보확인
0.종료

	8)연습
    package bank;

	public class Account {
	private String id;
	private String owner;
	private int balance;
	
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account 계좌=" + id + ", 성명=" + owner + ", 잔액=" + balance;
	}
	}
    
    
    package bank;

	public class AccountFunc {
	static Account[] count = new Account[100]; // 기억용
	static int accountCount = 0;

	public static void create(String id, String owner, int balance) {
		count[accountCount] = new Account();
		count[accountCount].setId(id);
		count[accountCount].setOwner(owner);
		count[accountCount].setBalance(balance);
		accountCount++;
	}

	static Account SearchAccount(String id) {
		for (int i = 0; i < accountCount; i++) {
			if (id.equals(count[i].getId())) {
				return count[i];
			}
		}
		return null;
	}
    }
    
    package bank;
	import java.util.Scanner;

	public class BankApp extends AccountFunc{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int userSel = -1;
		while (userSel != 0) {
			System.out.println("1.계좌생성");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.이체");
			System.out.println("5.계좌정보확인");
			System.out.println("0.종료");
			userSel = Integer.parseInt(scan.nextLine());

			if (userSel == 1) {
				System.out.println("계좌번호를 입력하세요.");
				String id = scan.nextLine();
				System.out.println("이름를 입력하세요.");
				String owner = scan.nextLine();
				System.out.println("금액를 입력하세요.");
				int balance = Integer.parseInt(scan.nextLine());
				create(id, owner, balance);
			} else if (userSel == 2) {
				System.out.println("입금할 계좌번호를 입력하세요.");
				String id = scan.nextLine();
				System.out.println("입금할 금액를 입력하세요.");
				int money = Integer.parseInt(scan.nextLine());
				Account a = new Account();
				a = SearchAccount(id);
				if (a != null) {
					a.setBalance(a.getBalance() + money);
					System.out.println("balance : " + a.getBalance());
					System.out.println("성공적으로 입금되었습니다.");
				} else
					System.out.println("계좌번호가 존재하지 않습니다.");
			} else if (userSel == 3) {
				System.out.println("출금할 계좌번호를 입력하세요.");
				String id = scan.nextLine();
				System.out.println("출금할 금액를 입력하세요.");
				int money = Integer.parseInt(scan.nextLine());
				Account a = new Account();
				a = SearchAccount(id);
				if (a != null) {
					if (money < a.getBalance()) {
						a.setBalance(a.getBalance() - money);
						System.out.println("balance : " + a.getBalance());
						System.out.println("성공적으로 출금되었습니다.");
					} else
						System.out.println("잔액이 부족합니다.");
				} else
					System.out.println("계좌번호가 존재하지 않습니다.");
			}

			else if (userSel == 4) {
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
			} else if (userSel == 5) {
				for (int i = 0; i < accountCount; i++)
					System.out.println(count[i].toString());
			} else
				System.out.println("그런 메뉴 없어요");
		}
	}
	}



