#DAY06
___
###생성자(contructor)
>객체가 생성될 때 필드에게 초기값을 제공하고 초기화 절차를 실행&호출되는 메소드
>
- 접근지정자는 일반적으로 public.
- 반환유형 없음.
- 함수명이 클래스명과 동일.
- overloading 가능
- 생성자를 하나도 정의하지 않으면 자동으로 디폴트 생성자가 만들어짐.

######+ 참고 toString 자동 완성 : source-generate toString

---
	1)
	public class Car {
	private int speed;
	private int mileage;
	private String color;
 
	public Car() {
	 System.out.println("생성자입니다.");
	 speed=0;
	 mileage=0;
	 color="white";
	}
	// public Car(String c) { 
	// this(0,0,c);
	//}
    public Car(int s, int m, String c) {
	speed=s;
	mileage=m;
	color=c;
	}
    }
    //정의된 생성자가 있을 경우 디폴트 생성자는 호출 불가=>에러
_ _ _
	public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();// 생성자 호출
		Car c2 = new Car(50,1200,"blue");
		System.out.println(c1);
		System.out.println(c2);
	}
	}
    //출력결과
    생성자입니다.
	Car [speed=0, mileage=0, color=white]
	Car [speed=50, mileage=1200, color=blue]



###가변길이인자 : ...
>들어오는 개수에 맞게 배열로 생성되어 저장
	
	Ex)
	public int sum(int numbers) {
	int sum=0;
	for(int n : numbers) sum+=n;
	return sum;
	}


___

	2)
	class Time {
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0,0,0);
		}
	public Time(int h, int m, int s) {
		setTime(h,m,s);
	}
	public void setTime(int h, int m, int s) {
		hour=((h>=0&&h<24)?h:0);
		minute=((m>=0&&m<60)?m:0);
		second=((s>=0&&s<60)?s:0);
		
	}
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
		//... : 가변 길이인자 들어오는 개수에 맞게 배열로 만들어져 
		
	}
	}
	public class TimeTest {	
	public static void main(String[] args) {
	
	Time time =new Time();
	System.out.print("기본생성자 호출 후 시간 : ");
	System.out.println(time.toString());

	Time time2=new Time(13,27,6);
	System.out.println("두번째 생성자 호출 후 시간 : ");
	System.out.println(time2);

	Time time3 =new Time(99,66,77);
	System.out.println("올바르지 않은 시간 설정 후 시간 :  ");
	System.out.println(time3);
	}
	}
	//출력결과
    기본생성자 호출 후 시간 : 00:00:00
	두번째 생성자 호출 후 시간 : 
	13:27:06
	올바르지 않은 시간 설정 후 시간 :  
	00:00:00
---

######+참고 : Hash 함수
>임의의 길이의 데이터를 고정된 길이의 데이터로 매핑
> 두 해시 값이 다르다면 원래의 데이터도 다르다
>- 로그인 처리
>- 다운로드 파일(전송된 데이터의 무결성을 확인)
>- 블록체인

---
	Ex)
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;

	public class Test {
	public static void main(String[] args) {
		String input="Park";
		for(int j=0;j<1000;j++) {
			String str=input+j;
			String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 

			md.update(str.getBytes()); 

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer(); 

			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		System.out.println(MD5);
		}
	}
	}
	

---
	3)깊은 복사
	public class Circle {
	private int radious;
	private Point center;

	public Circle() {
		radious = 0;
		center = new Point();
	}
	public Circle(int r, Point center) {
		radious = r;
		//this.center = center; shallow copy
		this.center=new Point(center.getX(), center.getY());
	}
	public int getRadious() {
		return radious;
	}
	public void setRadious(int radious) {
		this.radious = radious;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		Point a=new Point();
        //this.center=center; =>shallow copy
		//a=center? =>a가 주소를 가져서 ㄴㄴ
        //깊은 복사
		//a.setX(center.getX()); 
		//a.setY(center.getY());
		this.center.setX(center.getX());
        //생성자로 만들어진 공간에 지역변수 center.x값을 넣음.
		this.center.setY(center.getY());
        //생성자로 만들어진 공간에 지역변수 center.y값을 넣음.
	}
	@Override
	public String toString() {
		return "Circle : radious=" + radious + ", center= " + center;
	}
	}
    //출력결과
    Point : x=2, y=3
	Circle : radious=10, center= Point : x=2, y=3
	---------
	Point : x=10, y=20
	Circle : radious=10, center= Point : x=2, y=3
---

###정적 변수(static variable)
>모든 객체를 통틀어서 하나만 있는 변수
>- 객체가 없어도, 많아도 하나만 존재
>- 모든 객체가 공유해서 접근할 수 있는 변수 공간
>- 클래스 이름을 언급하는 순간 메모리에 올라감.

###정적(클래스) 메소드와 인스턴스 메소드
>정적 메소드 :객체의 상태값와 상관이 없는 동작을 메소드를 구현할 때 
>- 정적변수를 변경할 때 사용
>
>인스턴스 메소드 : 인스턴스(객체) 변수와 관련된 동작을 구현할 때
>- 객체 생성을 해야만 호출 가능.
>
>같은 클래스에 속  멤버들 간에는 별도의 인스턴스 생성을 하지 않고도 서로 참조&호출 가능.
>클래스 멤버가 인스턴스 멤버를 참조 또는 호출할 경우 인스턴스를 생성해야함.

---

	4)static
    ...(위 car 코드와 동일)
    public static int numberOfCars;
	public Car() {
		speed = 0;
		mileage = 0;
		color = "blue";	
		numberOfCars++;
	}
	public Car(int s, int m, String c) {
		speed = s;
		mileage = m;
		color = c;
		numberOfCars++;
	}

	public Car(String c) {
		this(0, 0, c);
		numberOfCars++;
	}
    ...
 
    public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car(); // 생성자 호출
		System.out.println(Car.numberOfCars);
        //static변수는 static을 통해 접근권장.
		Car c2 = new Car(50,1200,"blue");
		System.out.println(c2.numberOfCars);
		System.out.println(c1);
		System.out.println(c2);
	}
	}
    
    4-1)static
    ...(위 car 코드와 동일)
    private int id;
	public static int numberOfCars=0;
	public Car() {
		speed = 0;
		mileage = 0;
		color = "blue";	
		id=++numberOfCars;
	}
	public Car(int s, int m, String c) {
		speed = s;
		mileage = m;
		color = c;
		id=++numberOfCars;
	}

	public Car(String c) {
		this(0, 0, c);
		id=++numberOfCars;
	}
	public static int getNumberOfCars() {
		return numberOfCars;
	}
	...
    
	public class CarTest3 {
	public static void main(String args[]) {
	 Car c1=new Car(100,0,"blue");
	 Car c2=new Car(0,0,"white");
	 int n=Car.getNumberOfCars();
	 System.out.println(n);
	}
    }
    //출력결과
    2
    

---
	5)
    class Employee{
	private String name;
	private double salary;
	private static int count=0;
	
	public Employee(String n, double s) {
		name =n;
		salary=s;
		count++;
	}
	protected void finalize() {
    //void finalize()의 시그니처를 갖는 함수는 객체가 소멸될때 실행됨
		count--;
	}
	public static int getCount() {
		return count;
	}
	@Override
	public String toString() { 
    //String toString 함수를 구현하면 println에 참조변수 전달시 바로 실행
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	}
	public class EmployeeTest {
	public static void main(String[] args) {
	Employee e1,e2,e3;
	e1=new Employee("Kim", 35000);
	e1=new Employee("Choi", 50000);
	e3=new Employee("Park", 40000);
	
	int n=Employee.getCount();
	System.out.println("명수 : "+n);
	}
	}
----

######+ 참고 : void finalize(), String toString()
>- finalize(): void finalize()의 시그니처를 갖는 함수는 객체가 소멸될 때 실행됨
>- toString(): String toString 함수를 구현하면 println에 참조변수 전달시 바로 실행

	6)
    public class Complex {
	private double real;
	private double imag;
	public Complex( double a, double b) {
	 this.real=a;
	 this.imag=b;
	}
	public double getReal() {
	return real;
	}
	public void setReal(double real) {
	this.real = real;
	}
	public double getImag() {
	return imag;
	}
	public void setImag(double imag) {
	this.imag = imag;
	}
    
    //복소수 더하기
	public String Sum(Complex b) {
	double real=this.real+b.getReal(); 
    //getReal을 사용하지 않아도 가능.
    //접근 지정자는 객체 상태의 접근이 아닌 클래스에서의 접근!!
	double imag=this.imag+b.getImag();
	return real+ "+" +imag+"i";
	}
    //복소수 더하기 ver.2
    public static Complex Sum(Complex c1, Complex c2) {
	double real=c1.real+c2.real;
	double imag=c1.imag+c2.imag;
	return new Complex(real, imag);
	}
    
	//복소수 뺄셈
	public String Substract(Complex b) {
	double real=this.getReal()-b.getReal();
	double imag=this.getImag()-b.getImag();
	return real+ "+ (" +imag+"i)";
    
	//복소수 곱셈
    public String Multiple(Complex b) {
	double real=this.getReal()*b.getReal()-this.getImag()*b.getImag();
	double imag=this.getReal()*b.getImag()+b.getReal()*this.getImag();
	return real+ "+ (" +imag+"i)";
	}
    
    //복소수 나눗셈
	public String Divide(Complex b) {
	double real=this.getReal()*b.getReal()+this.getImag()*b.getImag();
	double imag=-(this.getReal()*b.getImag())+b.getReal()*this.getImag();
	if(b.getReal()*b.getReal()-b.getImag()*b.getImag()!=0) {
	this.real=real/(b.getReal()*b.getReal()-b.getImag()*b.getImag());
	this.imag=imag/(b.getReal()*b.getReal()-b.getImag()*b.getImag());
	return this.real+ "+ (" +this.imag+"i)";
	}
	else return "분모가 0";
	}

	@Override
	public String toString() {
	return "Complex :" +real +" + "+ imag+ "i" ;
	}
	}
    
	public class Complextest {
	public static void main(String[] args) {
		Complex com1 = new Complex(1, 4);
		Complex com2 = new Complex(1, 1);

		//Complex c3=c1.Sum(com2); => 주소값이 반환되므로 참조..
		System.out.println(com1.Sum(com2));
		System.out.println(com2.Substract(com1));
		System.out.println(com1.Multiple(com2));
		System.out.println(com2.Divide(com1));
	}
	}
---

###초기화
>멤버변수와 배열이 초기화 는 선택적이지만 지역변수의 초기화는 필수적이다.
>- 멤버변수 초기화 방법 : 명시적 초기화, 생성자, 초기화 블럭

###명시적 초기화
>변수를 선언과 동시에 초기화하는 것

###초기화 블럭
>클래스 초기화 블럭 : 클래스 변수의 복잡한 초기화에 사용
>- 초기화 시점 : 클래스가 처음 호출될 때
>
>인스턴스 초기화 블럭 : 객채의 변수의 복잡한 초기화에 사용
>- 초기화 시점 : 객체가 생성될 때 마다 수행

---
	7)
	public class BlockTest {
	static {
		System.out.println("static()");
		// 클래스 초기화 블럭
	}
	{
		System.out.println("( )");
		// 인스턴스 초기화 블럭
	}
	public BlockTest() {
		System.out.println("생성자 호출");
	}
	public static void main(String[] args) {
		System.out.println("BlockTest bt=new BlockTest();");
		BlockTest bt = new BlockTest();

		System.out.println("BlockTest bt2=new BlockTest();");
		BlockTest bt2 = new BlockTest();
	}
	}
    //출력결과
    static()
	BlockTest bt=new BlockTest();
	( )
	생성자 호출
	BlockTest bt2=new BlockTest();
	( )
	생성자 호출
---
	8)
	public class StaticBlock {
	static int[] arr = new int[10];
	static {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}
	}
	public static void main(String args[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr[" + i + "] :" + arr[i]);
	}
	}
	//출력결과
    arr[0] :5
	arr[1] :1
	arr[2] :7
	arr[3] :2
	arr[4] :8
	arr[5] :5
	arr[6] :6
	arr[7] :5
	arr[8] :1



