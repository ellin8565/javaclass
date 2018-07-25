#DAY08
___


변수 : 프로그램 동작 중에서 상태를 기억
제어문 : 프로그램의 동작을 분기 혹은 반복, 공통된 패턴을 묶음
함수 : 프로그램의 자주 사용되는 명령문을 재사용, 공통된 명령문 집합을 묶음
클래스 : 프로그램에서 사용될 사용자정의 자료형, 관련있는 변수와 함수를 묶음.
상속 : 여러클래스 간의 공통된 형태를 수직적으로 뽑아냄.
다형성 : 형태는 같지만 내부 동작이 다른 함수까지 뽑아낼 수 있도록 

###다형성(polymorphism)
>하나의 코드로 다양한 데이터를 처리하는 것.
>
>조상클래스 타입의 참조변수로 자손클래스의 객체를 참조할 수 있다. 
>- 이때는 부모타입에 존재하는 멤버에만 접근 가능.
>- 부모에 존재하는 멤버가 자식에도 존재한다면 부모 존재하니 접근은 되지만 실제 접근은 자식클래스의 멤버(__동적 바인딩__)
>- 자식영역에 접근하려면 형변환 필요
>ex) ((Rectangle)s).setWidth(10) : s는 shape 객체로 자식영역에 접근하기 위해 형변환
>ex) println(Object o) : 모든 자바 클래스들은 Object를 상속하고 있으므로 자식 클래스에서 구현하는 방식에 따라 출력
>
>자식클래스 참조변수로  부모 타입의 객체를 참조 불가


---
	0)
    package ex01;

	public class ShapeTest {
	private static Shape arrayofShape[];

	public static void main(String[] args) {
		init();
		drawAll();
	}

	public static void init() {
		arrayofShape = new Shape[3]; //같은 타입으로 처리할 수 있음.
		arrayofShape[0] = new Rectangle();
		arrayofShape[1] = new Triangle();
		arrayofShape[2] = new Circle();

	}

	public static void drawAll() {
		for (int i = 0; i < arrayofShape.length; i++) {
			arrayofShape[i].draw();
			//shape가 draw를 갖고 있는 것이 중요.(그 이외에 )
		}
	}
	}

    
	1)
    public class CastingTest {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		car = fe; //조상타입의 참조변수로 자손 타입의 객체 참조, 형변환 생략(자손->부모)
		//car.water();=>에러 car 타입의 참조변수로는 water 호출 불가
		fe2 = (FireEngine) car; //car은 FireEngine 객체를 참조상태
		fe2.water();
	}
	}

	class Car {
	String color;
	int door;
	void drive() {
		System.out.println("drive,Brr");
	}
	void stop() {
		System.out.println("stop");
	}
	}

	class FireEngine extends Car {
	void water() {
		System.out.println("water!");
	}
	}

	1-1)
	public class CastingTest {
	public static void main(String[] args) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
		car.drive();
		fe = (FireEngine) car;
        //실행 에러, 조상타입의 인스턴스를 자손타입의 참조변수로 참조 불가
		car2 = fe;
		car2.drive();
	}
	}
    
    1-1) 객체 타입 확인 instanceof
    
	public class InstanceTest {
	public static void main(String[] args) {
	FireEngine fe=new FireEngine();
	if(fe instanceof FireEngine) {
		System.out.println("This is a FireEngine instance.");
	}
	if(fe instanceof Car) {
		System.out.println("This is a Car instance.");
	}
	System.out.println(fe.getClass().getName());
	}
	}
    //출력결과
    This is a FireEngine instance.
	This is a Car instance.
	FireEngine

    1-2)
    class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
	}

	class Tv extends Product {
	Tv() {
		super(100);
	}

	// object 클래스의 toString 오버라이딩
	public String toString() {
		return "Tv";
	}
	}

	class Computer extends Product {
	Computer() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
	}
	class Buyer{
	int money=1000;
	int bonusPoint=0;
	void buy(Product p) {
		if(money<p.price) {
			System.out.println("잔약이 부족하여 물건을 살 수 없습니다.");
		return ;
		
		}
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"을/를 구입하셨습니다.");
			}
	}

	public class PolyArgument {
	public static void main(String[] args) {
	Buyer b=new Buyer();
	b.buy(new Tv());
	b.buy(new Computer());
	
	System.out.println("현재 남은 돈 : "+b.money);
	System.out.println("쌓인 포인트 : "+ b.bonusPoint);
	}
	}


---
	2)연습
    package ex02;

	class Tea {
	protected String name;

	public void kindOf() {
		System.out.println("Tea kindof");
	}
	}
	class EarlGrey extends Tea {
	public void kindOf() {
		System.out.println("EarlGrey");
	}
	}
	class Assam extends Tea {
	public void kindOf() {
		System.out.println("Assam");
	}
	}
	public class TeaTest {
	private static Tea kindofT[];
	public static void main(String[] args) {
		Tea[] a = new Tea[2];
		a[0] = new EarlGrey();
		a[1] = new Assam();
		for (int i = 0; i < a.length; i++) {
			a[i].kindOf();
		}
		Tea[] b = new Tea[2];
	}
	}
	//출력결과
    EarlGrey
	Assam

    
---
###디자인 패턴
>디자인 패턴은 과거의 소프트웨어 개발 과정에서 발견된 설계의 노하우를 축적하여 이후에 재이용하기 좋은 형태로 특정의 규약을 묶어서 정리한 것

### 템플릿 메소드 패턴
>상위 클래스(추상 클래스)에는 추상 메서드를 통해 기능의 골격을 제공하고, 하위 클래스(구체 클래스)의 메서드에서는 세부 처리를 구체화
>
 
###추상 클래스& 추상 메소드 : abstract
>추상 클래스: 미완성 메서드를 포함하고 있다는 의미.
>- 추상 클래스는 상속을 통해서 자손클래스에 의해서만 완성.
>- 추상클래스를 상속받으면 추상메소드 구현해야하거나 자신이 추상클래스로 선언해야함.
>- 추상클래스는 객체가 될 수 없다.
>
>추상 메소드 : 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨둔 것
> ex) public abstract void move();
> 




---
	3) //펀치공격, 미사일 공격등을 재사용 할 수 없음.
    public abstract class Robot {
	public abstract void attack();//추상메소드를 가지려면 추상 클래스여야함.
    //세부 동작은 자식클래스가 하므로 
	public abstract void move();
	public void fight() { //동작의 틀 제공
		move();
		attack();
		move();
	}
	}
    
	public class Mazinga extends Robot{
	public void attack() {
	System.out.println("미사일 공격");
	}
	public void move() {
	System.out.println("걸어서 이동");
	}
	public void fight() {
	move();
	attack();
	move();
	}
	}
    
	public class Taekwon extends Robot {
	public void attack() {
		System.out.println("펀피 공격");
	}
	public void move() {
		System.out.println("날아서 이동");
	}
	//public void fight() { //같은 동작.=>상속...
		move();
		attack();
		move();
	}
	}
    
	public class RobotTest {
	public static void main(String[] args) {
	Robot t1=new Taekwon();
	Robot t2=new Mazinga();
	
	t1.fight();
	t2.fight();
	}
	}
	//출력결과
    날아서 이동
	펀치 공격
	날아서 이동
	걸어서 이동
	미사일 공격
	걸어서 이동

---
	4)
    abstract class Person{
	public abstract void move();
	public abstract void lunch();
	public abstract void night();
	public void day() {
		move();
		lunch();
		night();
	}
	}

	class Employee extends Person{
	int salary;
	public void move() {
		System.out.println("출근하기");
	}
	public void lunch() {
		System.out.println("사내 식당 이용");
	}
	public void night() {
		System.out.println("야근");
	}
	}

	class student extends Person{
	int age;
	public void move() {
		System.out.println("등교하기");
	}
	public void lunch() {
		System.out.println("학교 급식");
	}
	public void night() {
		System.out.println("집가싶...");
	}
	}

	public class Test {
	public static void main(String[] args) {

	Person p1=new Employee();
	Person p2= new student();
	//Person p=new Person(); => 추상클래스로 객체 생성 안됨...만들다만 클래스
	Person p=new Person() {
		public void move() {
				}
		public void lunch() {}
		public void night() {}
	}; //미완성 부분에 대한 1회성 구현, 완성을 해주면 가능(익명 클래스)
	//Employee p3=null;
	//p=p1;
	//p3=(Employee)p;
	//p3.day();
	p1.day();
	p2.day();
	}
	}



---
###bank 객체화 연습

	5)
    //메인
	package bank;
	import java.util.Scanner;
    
	//메인
	public class BankApp  {
	public static void main(String[] args) {
		AccountFunc Manager=new AccountFunc();
		Manager.run();
	}
	}
___
	//각각 독립적으로 있을 수 있도록
    //나중에 console 쪽도 따로 빼서 구현하면..ㅇ,ㅁ..
	package bank;
	import java.util.Scanner;
	public class AccountFunc {

	Account[] count = new Account[100]; // 기억용
	int accountCount = 0;
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
			} else
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
		count[accountCount] = new Account();
		count[accountCount].setId(id);
		count[accountCount].setOwner(owner);
		count[accountCount].setBalance(balance);
		accountCount++;
	}

	private  Account SearchAccount(String id) {
		for (int i = 0; i < accountCount; i++) {
			if (id.equals(count[i].getId())) {
				return count[i];
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
		System.out.println("0.종료");
	}

	private  void in() {
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
	}

	private void out() {
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
		for (int i = 0; i < accountCount; i++)
			System.out.println(count[i].toString());
	}
	}
---
###solid 원칙

>==**S : 단일 책임 원칙**==
>-  한 클래스는 하나의 책임만 가져야 한다. 

>O : 개방-폐쇄 원칙 
>- “소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.” 

>L :  리스코프 치환 원칙 
>- “프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.” 계약에 의한 설계를 참고하라. 

>I: 인터페이스 분리 원칙 
>- 한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다는 원리

>==**D : 의존관계 역전 원칙** ==
> 하위 레벨 모듈의 변경이 상위 레벨 모듈의 변경을 요구하는 위계관계를 끊는 의미의 역전
> 실제 사용 관계는 바뀌지 않으며, 추상을 매개로 메시지를 주고 받음으로써 관계를 최대한 느슨하게 만드는 원칙.
>- 상위 계층이 하위 계층의 구현으로부터 독립
>- 의존성 역전 : 하위 객체에서 변경했다고 상위 객체의 변경을 하지 않아도 되도록...독립적...


---
	6) 단일 책임, 의존 관계 역전 원칙
    package ex04;
	public abstract class Attack {// 규격=>attack()기능에 대한 명세적
    //=>얘를 상속받은 클래스는 객체는 공격기능 구현
	public abstract void attack();
	}
___
	package ex04;
	public class MissileAttack extends Attack{
	 public void attack() {
	 System.out.println("미사일 공격");
	 }
	}
___
	package ex04;
	public class PunchAtt extends Attack {
	public void attack() {
		System.out.println("펀치로 공격");
		// 펀치 기능 하나만
	}
	}
___
    package ex04;
	public abstract class Move {
	public abstract void move();
	}
___    
    package ex04;
	public class FlyingMo extends Move {
	public void move() {
	System.out.println("날아서 이동!");
	}
	}
___   
	package ex04;
	public class FlyingMo extends Move {
	public void move() {
	System.out.println("날아서 이동!");
	}
	}
____	
    package ex04;
	public abstract class Robot {
	public abstract void attack();//추상메소드를 가지려면 추상 클래스여야함.
	public abstract void move();
	public void fight() { //동작의 틀 제공
		move();
		attack();
		move();
	}
	}
___
    package ex04;
	public class Mazinga {
	private Attack attack; // 타입의존성을 없앰.=> 공격클래스들의 부모클래스를 만들어서
	private Move move; //private Walk move;
	public Mazinga() {
		attack = new MissileAttack(); // 전략적으로 attack의 자식클래스중 넣고싶은 클래스를 넣는다.
		move = new Walk();
	}
	public void attack() {
		attack.attack();
	}
	public void move() {
		move.move();
	}
	}
	//단일 책임 원칙 적용으로 펀치공격 클래스 사용(참조변수 준비, 객체 생성)
___
	package ex04;
	public class Taekwon extends Robot{
	private Attack attack; 
	//타입의존성을 없애기 위해 공격 클래스들의 부모클래스를 만듦.
	private Move move; //private FlyingMo move; 
	public Taekwon() {
		attack=new PunchAtt();
		move=new FlyingMo();
	}
	public void attack() {
	attack.attack();
	}
	public void move() {
	move.move();
	}
	}
---
	package ex04;
	public class RobotTest {
	public static void main(String[] args) {
	Robot r1=new Mazinga();
	Robot r2=new Taekwon();
	r1.attack();
	r1.move();
	System.out.println("---------");
	r2.attack();
	r2.move();
	}
	}
    //출력결과
    미사일 공격
	걸어서 이동
	---------
	펀치로 공격
	날아서 이동!
---
