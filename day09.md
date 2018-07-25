#DAY08
___


###인터페이스
> 추상 메소드로만 이루어진 집합, 일반 메소드나 멤버변수를 구성원으로 가질 수 없음.
>
>- 모든 멤버변수 public static final, 모든 메서드 public abstract  =>생략가능
>- implements 
>- 다중상속 가능

---
	1)인터페이스 분리원칙
    package interf;
	public interface Attack { //기본 설계도....
	public void attack();
	}
___
	package interf;
	public class PunchAttack implements Attack{
	public void attack() {
		System.out.println("펀치로 공격");
	}
	}
___
	package interf;
	public class MissileAttack implements Attack{
	public void attack() {
	System.out.println("펀치로 공격!");
	}
	}
____
	
	package interf;
	public interface Move {
	public void move();
	}
____
    package interf;
	public class FlyingMove implements Move{
	public void move() {
	System.out.println("날아서 이동");
	}
	}
___
	package interf;
	public class WalkMove implements Move {
	public void move() {
		System.out.println("걸어서 이동");
	}
	}
___
	package interf;

	public class Robot {
    
	private Attack attack;
	private Move move;
	public void setAttack(Attack attack) { 
		this.attack = attack;
	}
	public void setMove(Move move) {
		this.move = move;
	}
    //↑↑ mazinga와 taekwon에서 내용이 같아서 robot으로 묶음.
    
	//private abstract void attack(); =>원래 추상클래스로 있었는데 내용 같아서...
	//private abstract void move();
	public void attack() {
	attack.attack();
	}
	public void move() {
	move.move();
	}
	public void fight() {
	move();
	attack();
	move();
	}
	}
___
	package interf;

	public class Taekwon extends Robot{
	//	//private PunchAttack attack=new PunchAttack() =>punchattack에 의존
	//	//private Attack attack= new PunchAttack();//attack에 추상화 된것에 의존,  느슨한 관계
	//	private Attack attack;
	//	public void setAttack(Attack attack) {
	//		this.attack = attack;
	//	}
	//		//=>누군가는 펀치 어택을 만들어서 setAttack에 넣어줘야함.(의존성 역전.)
	//	@Override
	//	public void attack() {
	//
	//	}
	//
	//	@Override
	//	public void move() {
	//		
	//	}
	}

___
	package interf;

	public class Mazinga extends Robot{ // taekwon과 똑같은 형태=>추상 메소드 필요없이 부모로 올리자....
	private Attack attack;
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	@Override
	public void attack() {
		attack.attack();
	}
	@Override
	public void move() {

	}
	}

___
	package interf;

	public class RobotTest {
	public static void main(String[] args) {
    //객체 생성, 선언이 외부에서...? robot쪽은 주입 타입...?, 기능이 바뀌어도 영향을 받지 않음.
	PunchAttack pa =new PunchAttack();
	MissileAttack ma=new MissileAttack();
	WalkMove wm = new WalkMove();
	FlyingMove fm=new FlyingMove();
	 
	Robot taek=new Robot();
	taek.setAttack(pa);
	taek.setMove(fm);
	taek.fight();
	
	Robot mazin= new Robot();
	mazin.setAttack(ma);
	mazin.setMove(wm);
	mazin.fight();

	Robot sunguard =new Robot();
	sunguard.setAttack(ma);
	sunguard.setMove(fm);
	sunguard.fight();
	
	Robot humanoid =new Robot();
	humanoid.setAttack(ma);
	humanoid.setMove(wm);
	humanoid.fight();
	}
	}



###내부 클래스
>클래스 내에 선언됨.
>- 외부클래스 내부에서만 사용되는 클래스에 대한 캡슐화(코드의 복잡성을 줄임)
>- 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있음.
>

___
	2)
	class OuterClass{
	private String secret="Time is money";
	 
	public OuterClass() {
		InnerClass obj=new InnerClass();
		obj.method();
		
	}
	private class InnerClass{
		public InnerClass() {
			System.out.println("내부 클래스 생성자 입니다.");
		}
		public void method() {
			System.out.println(secret);
		}
	}
	}
	public class Test {
	public static void main(String[] args) {
	new OuterClass();
	}
	}
    //실행결과
    내부 클래스 생성자 입니다.
	Time is money


	3)
	public class InnerEx {
		class InstanceInner{
			int iv=100;
			final static int CONST=100;
		}
		static class StaticInner{
			int iv=200;
			static int cv=200;
		}
		void myMethod() {
			class Localnner{
				int iv=300;
				final static int CONST=300;
			}
		}
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
	}
	//실행결과
    100
	200



---

###무명클래스(익명 클래스)
>클래스의 선언과 객체의 생성을 동시에 하기 때문에 단 한번만 사용될 수 있고 하나의 객체만을 생성할 수 있는 일회용 클래스
>-생성자 가질 수 없음


---

	package interf;

	public class Finally {
	 Object iv = new Object() { //익명 클래스
	 void method() { }
	 };
	 static Object cv= new Object() {//익명 클래스
	 void method() { }
	 };
	 void myMethod() {
	 Object lv=new Object() {void method(){} }; //익명 클래스
	}
	}
---



#####+많이 본 에러
- ArrayIndexOutOfBoundException : 배열의 잘못된 인덱스에 참조하면 프로그램 종료
- ClassCastException : 객체를 형변환 할 때 잘못된 타입으로 하면 프로그램이 종료
- NullPointerException : 참조값이 없는 참조변수에 연산자를 통해 접근하면 프로그램 종료


###예외
>잘못된 코드, 부정확한 코드 예외적 상황에 발생하는 오류



###예외처리
>Exception이 발생하더라도 후속조치를 수행하도록하고 프로그램이 종료되지 않고 계속 진행
>
>자바에서도 예외도 객체로 처리, 이 예외를 만들기 위한 클래스들도 상속계층구조를 가짐
>
>부모타입예외의 catch는 자식타입의 예외까지 잡을 수 있음.
>- try /catch 형태
>- catch는 위에서부터 검사하기 때문에 위쪽에 자식 타입을 먼저 넣어야함.
>- error: 예외 처리 대상이 아님, 권한 밖(운영체제로부터 오류->내 탓이 아님)
>- Runtime exception : 선택적 예외처리대상, 필요하다면 작성
>- IO Exception(input/output) : 필수적 예외처리대상(외부와 소통(입력,출력 등)과정에서 오류일 때)


###printStackTrace() & getMessage()
>printStackTrace(): 예외발생 당시 호출 스택에 있었던 메서드의 정보와 예외메시지 화면 출력
> getMessage(): 발생한 예외 클래스의 객체에 저장된 메시지를 얻음

---
	4)
	public class DivideByZero {
	public static void main(String[] args) {
		int x = 1;
		int y = 0;
		try {
			int result = x / y;  //=>이 안에서는 ArithmeticException에만 안정
            System.out.println("예외를 만나는 순간 catch행"); //출력되지 않음.
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램은 계속 진행됩니다.");
	}
	}
    //출력결과
    0으로 나눌 수 없습니다.
	프로그램은 계속 진행됩니다.

	5)
	public class DivideByZero {
	public static void main(String[] args) {
		int x = 1;
		int y = 0;
		try {
			int result = x / y;
			System.out.println("예외를 만나는 순간 catch행");
		} catch (ArithmeticException e) {
			//예외처리 안해서 프로그램 죽을 때 그 메시지 출력
			e.printStackTrace();
            //발생한 예외의 메시지 출력
			System.out.println(e.getMessage());
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("정상");
	}
	}
    //출력결과
    java.lang.ArithmeticException: / by zero
	at DivideByZero.main(DivideByZero.java:7)
	/ by zero
	0으로 나눌 수 없습니다.
	정상



###finally 블록
>  try/catch문에서 오류가 발생하였건 발생하지 않았건(return 문이 있더라도) 항상 실행되는 코드를 finally 블록에 넣을 수 있음.
> 

