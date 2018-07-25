*자바란?
-운영체제에 독립적 : 자바 애플리케이션은 JVM하고만 상호작용으르 하기 때무에 OS와 하드웨어에 독립적.(JVM의 버전은 운영체제에 따라 다름) 
-객체지향언어 : 상속 캡슐화 , 다향성

	1)주석
	public class Helloworld {
 	 public static void main(String[] args) { // 시작, 순차진행
    // 주석 : 컴파일러 실행시 무시하는 라인,
    System.out.println("Hello \t World!");
    System.out.println("자동 줄바꿈");
    System.out.println("호에에에에에엥");
    System.out.print("Hello\n");
    System.out.print("World");

	  }// 종료
	}
	/* 여러줄 주석을 줄 때 사용 */


---
	2)

	public class Helloworld {
    public static void main(String[] args) { 
    int a=50;
    //변수 : 메모리 상 주소에 붙여준 이름
    //타입만큼의 공간에 대해 이름이 붙는다. 
    System.out.println("자동차의 속도는 "+a+"입니다.");
    //System.out.println("자동차의 속도는 10올립니다.");  
    a=a+10;
    System.out.println("자동차의 속도는  "+a+"입니다.");
    
	  }
	}
	//출력결과


*변수(variable)
-변수 : 값을 저장할 수 있는 메모리 공간
-변수타입 : 저장하고자하는 값의 종류에 따라 선택,변수를 어떻게 읽어드릴지 결정.
-변수이름 : 변수에 붙인 이름. 

---
	3)VarEx1
	public class VarEx1 {
  	public static void main(String[] args) {
    int year = 0;
    int age = 14;
    System.out.println(year);
    System.out.println(age);
    year = age + 2000;
    age = age + 1;
    System.out.println(year);
    System.out.println(age);
  	}
	}
	//출력결과
	0
	14
	2014
	15

---
	4)VarEx2
	public class VarEx2 {
	public static void main(String[] args) {
    int x = 10, y = 20; 
    //정수를 하나 담을 수 있는 바구니, 이름 x
    int tmp = 0;
    System.out.println("x :" + x + " y:" + y);
    //+는 문자열과 숫자를 하나로 결합하기도 함.
    tmp = x; 
    //x값 담기(값 바꾸기를 위함)
    x = y;
    y = tmp;
    System.out.println("x :" + x + " y:" + y);
 	 }
	}

####변수 명명규칙
-변수는 소문자로 시작, 알아보기 쉽게 의미가 전달되게 지정.
-예약어 사용불가
-두 단어가 붙을 경우 두번째 단어 첫글자 대문자.
-클래스 이름의 첫글자는 항상 대문자.

---
	5)StirngEx
	public class StringEx {
	public static void main(String[] args) {
 	 String name ="Ja"+"va";
	 String str =name+8.0;
 	 System.out.println(name);
 	 System.out.println(str);
 	 System.out.println(7+ " ");
 	 System.out.println(" "+7);
 	 System.out.println(7+ "");
 	 System.out.println("" + 7);
 	 System.out.println("" + ""); 
	 System.out.println(7 + 7 + "");
  	 System.out.println("" + 7+ 7); //결과 77
 	 //+는 피연산자 중 어느 한쪽이 string 이면 나머지 한쪽을 먼저 string으로 변환
 	 //+는 왼쪽에서 오른쪽 방향으로 연산 수행
	}
	}

	//출력결과
	Java
	Java8.0
	7 
	 7
	7
	7

	14
	77

*변수의 타입
-기본형 : 실제 값을 저장(자료형 : boolean, char, int, double, short, char...)
-참조형 : 어떤 값이 저장되어 있는 주소을 값으로 갖음.

	6)
	import java.util.Scanner;

	public class ScannerEx {
	  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("숫자를 하나 입력하세요.");
    int a = scan.nextInt(); //입력을 기다리는 중.
    //사용자가 숫자를 입력하면 그 값을 호출한 자리에 
    System.out.println("당신이 입력한 숫자는 " + a + "입니다.");
	  }
	}


	6-1)
	import java.util.Scanner;

	public class ScannerEx {
	  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //scan 참조 변수(타입이 클래스이름), 힙영역 scanner객체의 주소 저장
    //동적, 실행 전에 크기를 알 수 없음.
  
    System.out.println("숫자를 입력하세요.");
    //system 꾸러미 속 out 꾸러미 속 println 기능
    int a = scan.nextInt(); 
    //입력을 기다리는 중, 사용자가 숫자를 입력하면 그 값을 호출한 자리에
    int b = scan.nextInt();
    int total = a + b;
    System.out.println("당신이 입력한 숫자의 합 : " + total);
    //System.out.println(a+b);
	  }
	}
	//출력결과
	숫자를 입력하세요.
	35 5
	당신이 입력한 숫자의 합 : 40

	+주석처리 된부분 : 40

*상수와 리터럴
-상수(constant) : 값을 저장할 수 있는 공간(다른 값으로 변경 불가)
  ex) final int MAX = 600;
-리터럴 : 그 자체로의 값을 의미
	6-2)
	import java.util.Scanner;

	public class ScannerEx2 {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("환산할 원화를 입력하세요.");
    double rate = 1180.7; 
    //프로그램이 실행되는 동안 변하지 않는 변수라면 final double =>변수를 변경할 수 없음.
    //final double RATE : 상수(symbolic literal,constant)이름은 대문자로 표기, 1180.7 :literal
    int won = scan.nextInt();
    double dollar = won / rate; //int와 double 연산 =>형변환
    System.out.println("1달러는 " + rate + "원 이므로");
    System.out.println("달러 환산 금액 : " + dollar);
  	}
	}
	//출력결과
	환산할 원화를 입력하세요.
	10000
	1달러는 1180.7원 이므로
	달러 환산 금액 : 8.469551960701278


+printf : 지시자(%f,%d..)를 통해 변수의 값을 여러가지 형식으로 변환하여 출력

	7)
	import java.util.Scanner;

	public class ScannerEx2 {
	  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("환산할 원화를 입력하세요.");
    double rate = 1180.7; 

    int won = scan.nextInt();
    double dollar = won / rate; //int와 double 연산 =>형변환
    System.out.println("1달러는 " + rate + "원 이므로");
    System.out.printf("%f 달러입니다.", dollar);
    }
	}
	//출력결과
	환산할 원화를 입력하세요.
	10000
	1달러는 1180.7원 이므로
	8.469552 달러입니다.

---
	8)특수문자 p57
	public class SpecialChar {
	public static void main(String[] args) {
	  System.out.println('\'');
	  System.out.println("abc\t123\b456");
	  System.out.println('\n');
	  System.out.println("\"Hello\"");
	  System.out.println("c:\\");
	  }
	}
	//출력결과
	'
	abc  123456


	"Hello"
	c:\
