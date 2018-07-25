2##DAY05
___
	0) day04 예제
	public class Test {
	public static void main(String[] args) {
	//동작 말로 서술+공통점확인->반복문
	//1~45사이 랜덤한 숫자 뽑기
	//0번째 배열 저장

	//1~45사이 랜덤한 숫자 뽑기2
	//0번째 값과 비교하여 같은 값이면 다시 뽑는다.
	//=>0번째 값과 다른 값이 나올때까지 반복!!
	//다른 값이면 1번째 배열에 저장.

	//1~45사이 랜덤한 숫자 뽑기3
	//1번째 값과 비교하여 같은 값이면 다시 뽑는다.
	//=>0~1번째 값과 다른 값이 나올때까지 반복!!(비교할 것이 늘어남)
	//다른 값이면 2번째 배열에 저장.
		
	int idx=0;//인덱스
	int[] lotto=new int[6];
	
	for(int i=0;i<lotto.length; i++) {
		int num=(int)(Math.random()*45)+1; //숫자 뽑기
		boolean flag1 =false; //상태를 기억하는 변수,비교할 것이 늘어나서
		for(int j=0; j<i;j++) {
		if(lotto[j]==num) flag1= true;//한번이라도 같은 적이 있다면 상태 변화
		}
		if(flag1) i--;
		else lotto[i]=num;
	}
	for(int num: lotto)
	System.out.print(num+ " ");
	}
	}
---
###객체지향언어
- 관련있는 변수와 함수가 하나로 묶여있음.
- 객체는 상태와 동작을 가지고 있다. 상태는 객체의 특징, 동작은 객체의 행동

####structure(구조체)
>사용자정의 자료형으로써 원하는 변수들을 묶어 만든 하나의 커다란 바구니.
	
- String : 값 뿐만 아니라 다양한 기능 포함.(클래스...?)

---
    1)
    class Person{ //새로운 타입을 만들어냄.
	int age;
	int score;
	String name;
	}
	public class Test2 {
	public static void main(String[] args) {
		int a=10; // int는 정수를 담을 수 있는 공간
		//기초자료형인 int 타입 변수는 변수명 자체가 데이터 공간
		Person p=new Person();
        //p는 실제 데이터가 아닌 데이터의 위치로 실제 데이터를 만드는 것은 new
		p.age=24;
		p.score=100;
		p.name="HONG";
		System.out.println(p.age);
		System.out.println(p.score);
		System.out.println(p.name);
        
		String str = "Hello World";
		System.out.println(str.substring(5)); 
        // string은 값 뿐만 아니라 기능 포함.
	}
	}
    

    1-1)
    public class StringTest {
	public static void main(String[] args) {
	String proverb="A barking dog";
	String s1,s2,s3,s4; //참조 변수로서 메소드에서 반환도니 참조값을 반는다.
	
	System.out.println("문자열의 길이 : "+ proverb.length());
	
	s1=proverb.concat(" never Bites");
	s2=proverb.replace('B','b');
	s3=proverb.substring(2,5);
	s4=proverb.toUpperCase();
	
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	System.out.println(s4);
	}
	}
    //출력결과
    문자열의 길이 : 13
	A barking dog never Bites
	A barking dog
	bar
	A BARKING DOG

---

####Class
>객체를 생성하기 위한 틀, 관련있는 필드(멤버변수)와 메서드(멤버함수)를 묶어놓은 사용자정의 자료형으로 그 클래스로 new 해서 만든 데이터가 객체.

- 일반적으로 상태(필드)는 객체내부에서만 조작 가능하도록 private 선언
- Car myCar : 객체를 가리키는 참조값을 담을 수 있는 변수만 생성됨, 객체생성X
- Car a=new Car(): 객체 생성, a에 저장되어있는 것은 어떤 자동차 데이터의 주소


####파라미터,매개변수,return 값 
- 파라메터 : 매개변수로 전달되어지는 값
- 매개변수 : 호출시에 넘겨주는 값을 받는 변수
- return 값 : 함수가 명령을 수행 후 값을 갖다주는 것.
---

	2)
    class Car{
    //필드 정의
	public int speed;
	public int mileage;
	public String color;
	//메소드 정의
	public void speedUp() {
		speed+=10;
		}
	public void speedDown() {
		speed-=10;
		}
	public String toString() {
		return "속도 :" +speed+ " 주행거리 :" +mileage+ " 색상 :"+color;
		}
	}
	public class CarTest {
	public static void main(String[] args) {
	Car myCar=new Car();
	Car yourCar=new Car();
	
	myCar.speed=60;
	myCar.mileage=0;
	myCar.color="blue";
	
	myCar.speedUp();
	System.out.println(myCar);
	
	yourCar.speed=120;
	yourCar.color="white";
	yourCar.mileage=10;
	
	yourCar.speedDown();
	System.out.println(yourCar);//bc toString 오버라이딩
    //toString 함수로만 가능.
    //System.out.println(yourCar.toString);
	}
	}
    //출력결과
    정수 버전 호출
	속도 :40 주행거리 :0 색상 :blue
	실수 버전 호출
	속도 :110 주행거리 :10 색상 :white
    
    
####객체의 소멸
>객체는 참조가 없어지면 소멸한다.

- 어떤 참조변수도 자신을 가리키지않는 힙영역 데이터는 소멸한다.
- 참고 : 지역변수 : 함수 안에 만들어지는 변수로 함수가 종료될 때 소멸


####메소드 오버라이딩
>하위 클래스가 자신의 상위 클래스들 중 하나에 의해 이미 제공된 메소드를 특정한 형태로 구현

- 실행되는 메소드의 버전은 사용되는 객체에 의해서 결정
- 하위클래스의 객체가 메소드를 발생시키는데 사용된다면 자식 클래스의 메소드 형태 실행

---
	3)
    import java.util.Scanner;

	public class DiceGame {//같은 프로젝트 내에서 접근가능
	 int diceFace;
	 int userGuess;
	 private void RollDice() {
	 diceFace=(int)(Math.random()*6)+1;
	 }
	 private int getUserInput(String prompt) {
	 System.out.println(prompt);
	 Scanner s= new Scanner(System.in);
	 return s.nextInt();
	 }
	 private void checkUserGuess() {
	 if (diceFace==userGuess)
		 System.out.println("맞음");
	 else 
		 System.out.println("틀림");
	 }
	public void startPlaying() {
	userGuess=getUserInput("예상값을 입력하시오.");
    //int userGuess일 때는 지역변수...일 때 
	RollDice();
	checkUserGuess();
	}
	}
	---
    
	public class DiceGameTest {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		game.startPlaying();
		//rollDice, checkUserGuess...=>private 상태로 외부에서 접근 불가
	}
	}
####오버로딩
>반환값과 이름이 같은데 매개변수의 개수,자료형,순서에 따라 다른 메소드 호출


---

	4)오버로딩
    class Car{
	public int speed;
	public int mileage;
	public String color;

	public void setSpeed(int s) { //메소드 오버로딩
		speed=s;
		System.out.println("정수 버전 호출");
				}
	public void setSpeed(double s) { //메소드 오버로딩
		speed=(int)s;
		System.out.println("실수 버전 호출");
		}
	public void speedUp() {
		speed+=10;
		}
	public void speedDown() {
		speed-=10;
		}
	public String toString() {
		return "속도 :" +speed+ " 주행거리 :" +mileage+ " 색상 :"+color;
		}

	}
	public class CarTest {
	public static void main(String[] args) {
	Car myCar=new Car();
	Car yourCar=new Car();
	
	myCar.setSpeed(30);
	myCar.mileage=0;
	myCar.color="blue";
	
	//	myCar.speedUp();
	System.out.println(myCar);
	
	yourCar.setSpeed(120.2);
	yourCar.color="white";
	yourCar.mileage=10;
	
	//	yourCar.speedDown();
	System.out.println(yourCar);//오버라이딩
	}
	}
--- 

####설정자와 접근자
>설정자 : SETTER, 값을 주어 대신 필드에 저장해주는 역할 
-  setXXX ...

>접근자 : GETTER, 값을 받아 필드 값을 반환해주는 역할
- getXXX ...return 필드

- 사용하면 상태값을 은닉화시켜서 객체지양원칙에 더 충실, 입력값에 대한 검증이 가능
- getter. setter 중 하나만 제공하면 읽기전용 혹은 쓰기 전용을 접근권한 세분화
- 참고 : source-generate Getters and Setters-생성할 변수 선택

+참고 : 캡슐화

---
	5)
    class Car {
	private int speed;
	private int mileage;
	public String color;

	public void setSpeed(int s) {
		speed = s;
		System.out.println("정수 버전 호출");
	}
	public void setmileage(int mileage) {
		this.mileage = mileage; //car의 mileage=함수의 지역변수 mileage
	}
	public int getSpeed() {
		return speed;
	}
	public int getMileage() {
		return mileage;
	}
    public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public String toString() {
		return "속도 :" + speed + " 주행거리 :" + mileage + " 색상 :" + color;
	}
	}

	public class CarTest {
	public static void main(String[] args) {
	Car myCar = new Car();
    myCar.setSpeed(30);
	myCar.setmileage(10000);
    myCar.setColor("RED");
	System.out.println("color : "+myCar.getColor());
	System.out.println("speed : " + myCar.getSpeed());
	System.out.println("mileage : "+ myCar.getMileage());
	System.out.println(myCar);
	}
	}
--- 

	6)실습
    class Employee {
	private String name;
	private String position;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() { //source-generate toString
		return "이름 :" + name + " 직급 :" + position + " 연봉 : " + salary;
	}
	}

	public class Employeetest {
	public static void main(String[] args) {
		Employee em1=new Employee();
		em1.setName("김");
		em1.setPosition("사원");
		em1.setSalary(3000);
		System.out.println(em1.getName());
		System.out.println(em1.getPosition());
		System.out.println(em1.getSalary());
		System.out.println(em1);
	}
	}
---

	7)
    class Employee {
	private String name;
	private String job;
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	private int salary;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() { //source-generate toString
		return "이름 :" + name  + " 연봉 : " + salary+ " 직급 :" + job;
	}
	}

	public class Employeetest {
	public static void main(String[] args) {
		Employee em1=new Employee();
		em1.setName("김");
		em1.setSalary(3000);
		System.out.println(em1.getName());
		System.out.println(em1.getSalary());
		System.out.println(em1);
	}
	}
    
___
    import java.util.Scanner;

	public class EmployeeArr {
	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	Employee[] empArr = new Employee[3]; // ampArr은employee형 데이터의 주소 저장
	for (int i = 0; i < empArr.length; i++) {
	empArr[i] = new Employee(); // 객체생성, 객체의 주소를 저장.
	System.out.println("직원 " + (i + 1) + "의 이름: ");
	empArr[i].setName(scan.nextLine());// nextLine 엔터가 눌릴 때까지 입력을 받음.
	System.out.println("직원 " + (i + 1) + "의 급여: ");
	empArr[i].setSalary(scan.nextInt());// 4바이트 숫자만 입력받음.enter를 입력받지 않으.ㅁ
	scan.nextLine();
	System.out.println("직원 " + (i + 1) + "의 직무: ");
	empArr[i].setJob(scan.nextLine());
	}
	int sel = 0;
	int sum = 0;
	while (sel != -1) {
		System.out.println("1.급여총합");
		System.out.println("2.모두보기");
		System.out.println("3.성이 K인 사람");
		System.out.println("4.정렬");
		System.out.println("-1.종료");
		sel = scan.nextInt();
		scan.nextLine();
		if (sel == 1) {
			for (int i = 0; i < empArr.length; i++)
				sum += empArr[i].getSalary();
			System.out.println("급여총합 : " + sum);
			}
		if (sel == 2) {
			for (Employee e : empArr)
				System.out.println(e);
		}
		if (sel == 3) {
			String n = scan.nextLine();
			for (int i = 0; i < empArr.length; i++) {
				if (empArr[i].getName().charAt(0) == n.charAt(0))
					System.out.println("성 :" + empArr[i].getName());
			} 
			}
		if(sel==4) {
			char[] a=new char[3];
			for (int j=0;j<3;j++) {
				a[j]=empArr[j].getName().charAt(0); }
			
			for (int i=0;i<a.length;i++) {
				char min=a[i];
				int minI=i;
				for(int j=i;j<a.length;j++) {
					if(min>a[j]) { 
						min=a[j];// 최소값 저장
						minI=j;//최소값의 자리 저장
					}
					}
				char tmp=a[i];
				a[i]=min; //최소값 저장
				a[minI]=tmp; //바꿀값 자리에 최소값 아닌 것 저장
				}
			for (char p: a) System.out.println(p);}
			}
			}
	}

