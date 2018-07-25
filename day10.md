#DAY10
___
2G/ 3G : 어플리케이션 사용
###예외
>프로그램이 죽음

###예외처리
> 컴파일 에러(문법 오류), 런타임 에러, 로지컬 에러
> throws : 예외 발생, 예외 전달
> 예외가 발생하더라도 계속해서 프로그램이 진행될 수 있도록 
> 잘 쓰면 열린 프로그램 작성 가능.

###throws
>특히 checkingEx
>그 블럭 내에 발생한 오류를 자신이 처리하지 않겠다.
>new를 통해 예외 객체 생성, throw 를 통해 예외 발생 : throw new ...exception

---
	1)
    public class CheckingExceptionTest {
	public static void main(String[] args) {
	//Thread.sleep(1000); => 메모리상 지워질 대상 1순위..
	for(int i=10;i>0; i--) {
		try {
			Thread.sleep(1000);	//명령 흐름 중지
		} catch (InterruptedException e) {

			e.printStackTrace();
		} 
		if(i==3)	System.out.println(i);
	}
	}
	}
    //
    
    1-1)
    
    
----
	2)
    import java.io.IOException; //IOException도 클래스명

	public class Test {
	public static void main(String[] args) {
	System.out.println(readString());
	}
	public static String readString() {
	byte[] buf = new byte[100]; //바이트 배열
	System.out.println("문자열 입력");
	try {
		System.in.read(buf); //입력받음
	}catch(IOException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return new String(buf); //바이트 배열 문자열로
	}
	}

	2-1)
    

###사용자 정의 예외처리 
>Exception 클래스의 서브 클래스를 생성시켜서 만든다. 



---
	3)
    class DivideZero extends ArithmeticException{
	public DivideZero() {
		super ("0으로 나눌 수는 없음."); //message
	}
	}
	public class ExceptionTest {
	public static void main(String[] args) {
		double result;
		try {
			result=quotient(1,0);
		}
		catch (DivideZero e) {
			System.out.println(e.toString()); //toString 오버라이딩
		}
	}
	public static double quotient(int n, int d) throws DivideZero{
	if(d==0) throw new DivideZero(); //new 예외 생성.
	//throw : 예외를 예외로 동작시키게, 예외를 던짐.
	return (double)n/d;
	}
	}

    //출력결과
    DivideZero: 0으로 나눌 수는 없음.

	3-1)
    class MyException extends Exception{
	public MyException() {
		super("사용자 정의 예외");
	}
	}
	public class ExceptionTest1 {
	public static void main(String[] args) {
	try {
		method();
		
	}catch (MyException e) {
		System.err.println(e.getMessage());	
		e.printStackTrace();
	}
	}
	public static void method() throws MyException{
	throw new MyException();
	}
	}
	//출력결과
    사용자 정의 예외
	MyException: 사용자 정의 예외
	at ExceptionTest1.method(ExceptionTest1.java:17)
	at ExceptionTest1.main(ExceptionTest1.java:9)


	3-2)
    import java.util.Scanner;

	class MyExcep1 extends Exception{
	public MyExcep1() {
		super("음수입니다.");
	}
	}
	public class Test2 {
	public static void main(String[] args) {
	
	Scanner scan= new Scanner(System.in);
	int a= scan.nextInt();
	try {
		method(a);
	}
	catch (MyExcep1 e){
		System.out.println(e.toString());
		System.err.println(e.getMessage());
		e.printStackTrace();
	}
	}
	public static void method (int a) throws MyExcep1{
	if (a<0) throw new MyExcep1();
	}
	}
	//출력결과
    -9
	MyExcep1: 음수입니다.
	음수입니다.
	MyExcep1: 음수입니다.
	at Test2.method(Test2.java:23)
	at Test2.main(Test2.java:14)

----
###Thread(스레드)
>프로세스(프로그램의 실행 단위) 보다 작은 **실행 흐름**의 최소 단위
>- 프로세스는 최소 하나의 스레드를 가지며 그것을 메인 스레드임.
>- 프로세스가 동시에 두 가지 이상의 일을 하려면 스레드가 두 개 이상이어야 함.
>- 명령처리 흐름은 thread라는 객체로 표현됨
>- 구현방법 : thread 상속, Runnable 인터페이스 구현


###병렬처리
>멀티프로세스 : 
>각 프로세스가 별도의 메모리를 가지며 어떻게 데이터를 공유할 것인가 ()
>ex) 크롬
>멀티 스레드 : 하나의 프로세스 여러개의 스레드
>- 여러개의 명령 흐름이 하나의 메모리 공간을 공유(어떻게 교통정리)
>synchronized : 하나의 스레드 만이 공유 데이터를 접근
    
----
    4)
    package thread;

	class Test extends Thread {
	public void run() {	
	for(int i=0;i<10;i++)  System.out.println(i);
	}
	}
	public class ThreadTest {
	public static void main(String[] args) {
		Thread t=new Test();
		t.start();
	}
	}
    //출력결과
    0...9

	5) runnable
    class Account{
	int balance;
	public void interest() {
		balance *= 1.1;
	}
	}
	class InterestThread implements Runnable{
	Account account;
	public InterestThread(Account account) {
		this.account =account;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.interest();
		}
	}
	}
	public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account();
		account.balance = 1000;
		new Thread(new InterestThread(account)).start();
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(account.balance);
		}
		
	}
	}



    
----
###병렬처리
동시에 여러개
명령흐름이 대기 해야됨에도 불구하고 동시에 다른 작업이 하고 싶을 때
명령처리시간이 오래걸리는 작업을 함에도 다른 작업이 동시에 수행되야될 때


	5)문제점 : 2개각 동시에 account 객체에 balance를 건들임.
    package thread;

	class Test extends Thread {
	public void rㅕn() {
	 for(int i=0;i<10;i++)  System.out.println(i);
	}
	}
	public class ThreadTest {
	public static void main(String[] args) {
		Thread t=new Test();
		t.start(); //start라는 메소드는 내가 정의하지 않았음. Thread클래스가 정의
		//start 호출=>새로운 명령처리흐름이 만들어짐 => run 실행
		//새로운 명령처리 흐름
		//t.run();=>run 함수 그냥 호출, 메인 스레드에서  run 함수 수행
		Thread t1=new Test();
		t1.start(); //t와 동시에 실행
	}
	}
    //출력결과
    

	6)synchronized
    package bankThread;

	class BankAccount {
	int balance;

	public void deposit(int amount) {
    //public synchronized void deposit(int amount)
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}
	}

	class User implements Runnable {
	BankAccount account;

	public User(BankAccount account) {
		this.account = account;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(10000);
			try {
				Thread.sleep(99);
			} catch (InterruptedException e) {
			}
			account.withdraw(10000);
			if (account.getBalance() < 0) {
				System.out.println("오류 발생!");
			}
		}
	}
	}

	public class BankTest {
	static BankAccount account = new BankAccount();

	public static void main(String[] args) {
		Thread one = new Thread(new User(account));
		Thread two = new Thread(new User(account));

		one.start();
		two.start();
	}
	}
    //출력결과
    오류 발생!
	오류 발생!
	오류 발생!
   
    
	6-1)
	package thread;

	import java.util.Random;

	class Horse implements Runnable{
	String name;
	private int sleepTime;
	private final static Random generator=new Random();
	public Horse(String name) {
		this.name=name;
		sleepTime =generator.nextInt(3000);
	}
	public void run() {
		try {
			Thread.sleep(sleepTime);
		}catch(InterruptedException e) {
		
		}
	System.out.println(name+"말이 경주를 완료했습니다.");
	}
	}
	public class TestThread2 {
	public static void main(String[] args) {
		
		Thread t1=new Thread(new Horse("질풍"));
		Thread t2=new Thread(new Horse("번개"));
		Thread t3=new Thread(new Horse("적토"));
		t1.start();
		t2.start();
		t3.start();
	}
	}
    //출력결과
    번개말이 경주를 완료했습니다.
	적토말이 경주를 완료했습니다.
	질풍말이 경주를 완료했습니다.


   
	7)
	class Counting implements Runnable{
	public void run()  {
		for (int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	}
	class RocketThread implements Runnable{
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("연료통 분리");
		try {
			Thread.sleep(10000); //느리게 뜨시네요
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("발사!");
	}
	}
	public class Rocket {
	public static void main(String[] args) {
	Thread counting= new Thread(new Counting());
	counting.start();
	Thread rocket= new Thread(new RocketThread());
	rocket.start();
	}
	}
    //출력결과
    10
	9
	8
	7
	6
	5
	연료통 분리
	4
	3
	2
	1
	발사! 


