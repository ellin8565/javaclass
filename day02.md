####클라우드 컴퓨팅(cloud computing)
-인터넷 기반 컴퓨팅의 일종으로 정보를 자신의 컴퓨터가 아닌 인터넷에 연결된 다른 컴퓨터로 처리하는 기술

####2의 보수법
-1의 보수 +1

-오버플로우 : 타입이 표현할 수 있는 값의 범위를 넘어서는 것
+가장 큰수에서 1을 더하면 가장 작은 수가 되고 가장 작은 수에서 1을 빼면 가장 큰수
ex) 0111(2)+1 => 1000(2) =>(2의 보수, 부호 -인 것 먼저확정) 0111(2) +1= -8


####인코딩, 디코딩
-인코딩 : 문자를 코드로 변환
-디코딩 : 코드를 문자로 변환하는 것.(저장된 문자를 읽어올때)
ex) UTF-8(한글 인코딩), 아스키코드


    1)
    import java.util.Scanner;

    public class Test {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("월급여를 입력하세요.");
    int salary = scan.nextInt();
    System.out.printf("연봉 :");
    System.out.println(salary * 12 + "만원");
    }
    }

---
####오버플로우
    2)overflow

	public class Overflow {
	public static void main(String[] args) {
		short sMin = -32768;
		short sMax = 32767;
		char cMin=0;
		char cMax=65535;
		
		System.out.println("sMin =" +sMin);
		System.out.println("sMin-1 =" +(short)(sMin-1));
		System.out.println("sMax =" +sMax);
		System.out.println("sMax+1 =" +(short)(sMax+1));
		System.out.println("cMin =" +(int)cMin);
		System.out.println("cMin-1 =" +(int)--cMin);
		System.out.println("cMax =" +(int)cMax);
		System.out.println("cMax+1 =" +(int)++cMax);
	}
	}
    //출력결과
    sMin =-32768
	sMin-1 =32767
	sMax =32767
	sMax+1 =-32768
	cMin =0
	cMin-1 =65535
	cMax =65535
	cMax+1 =0

---

####형변환 : 변수 또는 상수의 타입을 다른 타입으로 변환


---
    3)
    public class ArithmeticOper {
     public static void main(String[] args) {
      // 계산결과가 정수, 실수인 값을 저장할 변수
      int result;
      double resultDouble;

      // 형변환 : 데이터 타입이 변하는 것
      // 묵시적 형변환 : 작은 타입의 데이터를 큰 타입의 변수에 담을 때
      // 작은 타입의 데이터를 큰 타입의 데이터와 연산할 때
      // 작은 타입의 데이터를 큰 타입으로 자동 변환
      resultDouble = 3;
      System.out.println(resultDouble); // 3.0

      // 작은 타입의 데이터를 큰 타입의 데이터와 연산할 때
      // 작은 타입의 데이터를 큰 타입으로 자동 변환
      resultDouble = 3.0 / 2;
      System.out.println(resultDouble);

      resultDouble = 3 / 2;
      System.out.println(resultDouble);

      resultDouble = 3 / (double) 2; //1.5가 나오도록
      System.out.println(resultDouble);
   
      // 명시적 형변환 : 큰 타입의 데이터를 작은 타입의 변수에 담기 위해서 강제로 작은 타입으로 형변환
      result = (int) 3.5;
      System.out.println(result); // 3
     
      // 연산결과 실수, 같은 타입의 연산 결과는 항상 같은 타입(정수 나눗셈 유의)
      result = 3 / 2;
      System.out.println(result); // 1
     }
     }

    //출력결과
    3.0
    1.5
    1.0
    1.5
    3
    1

####산술연산자 , 논리연산자
**산술연산자**|%|/| + | -|...
--|---|---|--|--|
**논리연산자**|~|^|&& |!|...
####단항 연산자
	++x 
	x++ 
	x-- 
    --x
---

    4)Operator

    public class Operator {
     public static void main(String[] args) {
      int x = 10;
      int y = 10;
      int z;

      x++;
      System.out.println("x : " + x);
      --y;
      System.out.println("y : " + y);
      System.out.println("---------------");
      z=x++;
      //z=x;
      //x=x+1;
      System.out.println("z : " + z);
      System.out.println("x : " + x);
      System.out.println("---------------");
      z=++x;
      //x=x+1;
      //z=x;
      System.out.println("z : " + z);
      System.out.println("x : " + x);
     }
    }

    //출력결과
    x : 11
    y : 9
    ---------------
    z : 11
    x : 12
    ---------------
    z : 13
    x : 13


    4-1)

    public class Operator2 {
	public static void main(String[] args) {
		int i = 5, j = 0;
		j = i++;
		System.out.println("후 : i= " + i + " j= " + j);
		i = 5;
		j = 0;
		j = ++i;
		System.out.println("후 : i= " + i + " j= " + j);
	}
    }

    //출력결과
    후 : i= 6 j= 5
    후 : i= 6 j= 6
    

    4-2)
    public class Operator3 {
     public static void main(String[] args) {
      int i = -10;
      i = +i;
      System.out.println(i);

      // i=-10;
      i = -i;
      System.out.println(i);
     }
    }

    //출력결과
    -10
    10


---
    5)

    public class Operator5 {
     public static void main(String[] args) {
      int a = 10;
      int b = 4;

      System.out.printf("%d + %d =%d\n", a, b, a + b);
      System.out.printf("%d - %d =%d%n", a, b, a - b);
      System.out.printf("%d * %d =%d%n", a, b, a * b);
      System.out.printf("%d / %d =%d%n", a, b, a / b);
      System.out.printf("%d / %f =%f%n", a, (float)b, a / (float)b);
     }
    }

    //출력결과
    10 + 4 =14
    10 - 4 =6
    10 * 4 =40
    10 / 4 =2
    10 / 4.000000 =2.500000
---

+논리에러, 컴파일에러, 런타임 에러


    6)
    public class Operator6 {
     public static void main(String[] args) {
      byte a = 10;
      byte b = 20;
      // byte c= a+b; =>에러
      //연산자 +가 두개의 byte형 피연산자들의 자료형으 int형으로 변환한 다음 연산을 수행하여 a+b의 연산결과는 int형=>형변환 필요
      byte c = (byte) (a + b);
      System.out.println(c);
     }
    }

    //출력결과
    30
    

---

    7)
    public class Operator7 {
     public static void main(String[] args) {
      int a=1_000_000;
      int b=2_000_000;

      long c=a*b; //오버플로우
      //int 타입의 연산결과는 int 타입으로 long으로 자동 형변환 되어도 값은 변하지 않음.
      System.out.println(c);
     }
    }

    //출력결과
    -1454759936
---
    7-1)
    public class Operator7 {
     public static void main(String[] args) {
      long a=1_000_000*1_000_000;
      long b=1_000_000*1_000_000L;
      //자동형변환, long 타입의 연산
      System.out.println("a: "+a);
      System.out.println("b: "+b);
     }
     }

    //출력결과
    a: -727379968
    b: 1000000000000
----
    8)

    public class Operator8 {
	public static void main(String[] args) {
		char c1 = 'a';
		// char c2=c1+1; =>에러
		// 변수가 들어있는 경우 컴파일러가 미리 계산을 할 수 없음.
		char c2 = 'a' + 1; // 상수간의 연산
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
	}
    }

	//출력결과
	c1 : a
	c2 : b

+상수 구분
10 => 숫자 10이라는 정수형 상수(int)
'H' =>문자 H라는 문자형 상수(char)
"H" =>문자열 H라는 문자열 상수(string)
"Hong" =>문자열 Hong라는 문자열 상수(string)
ture =>진리값 true

####관계연산자
-숫자들 간에 대소비교 혹은 동등비교 '연산'을 수행한 후 결과로써 true/false의 결과값을 나타내는 연산자


    9)
    public class Operator21 {
	public static void main(String[] args) {
		System.out.printf("10==10.0f  \t %b%n", 10 == 10.0f);
		System.out.printf("'0'==0     \t %b%n", '0' == 0);
		System.out.printf("'A'==65    \t %b%n", 'A' == 65);
		System.out.printf("'A'=='B'   \t %b%n", 'A' == 'B');
		System.out.printf("'A'+1!='B' \t %b%n", 'A' + 1 != 'B');
	}
    }

    //출력결과
	10==10.0f  	 true
	'0'==0     	 false
	'A'==65    	 true
	'A'=='B'   	 false
	'A'+1!='B' 	 false
---
####논리연산자
-피연산자가 true/false 타입으로 연산 결과도 true/false
-AND연산(&&) : 둘다 true일 때 true
-OR연산(||) : 어느 한 쪽만 true이면 true
ex)p.115

####삼항 연산자
-condition? exp1:exp2 
: 결과가 true이면 exp1의 값으로 연산식의 결과가 결정. 결과가 false이면 exp2의 값으로 결과 결정.

---
	10)
	import java.util.Scanner;

	public class FindMaxVal {
	public static void main(String[] args) {
		//double result;
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 2개 입력하세요.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int Max = a >b ? a : b;
		//result = (a+b)/2.0;
		//System.out.println(result); => 평균값내기
		System.out.println("MAX : " +Max);	
        }
        }
	
    //출력결과
    숫자를 2개 입력하세요.
	34 5
	//19.5
	MAX : 34

	10-1)
	import java.util.Scanner;

	public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char grade;
		System.out.println("점수를 입력하세요.");
		int score=scan.nextInt();
		grade =score>70? (score>80?'A':'B'):(score>40?'C':'D');
		//exp 자리에 연산식이 들어갈 수 있음.
		System.out.println("성적 : "+ grade);
	}
	}

	//출력결과
    점수를 입력하세요.
	50
	성적 : C

	10-2)
    import java.util.Scanner;

	public class Prices {
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int price;
	int quantity;
	int total;
	System.out.printf("상품의 가격 : ");
	price=scan.nextInt();
	System.out.printf("상품의 개수 : ");
	quantity=scan.nextInt();
	total =quantity>5? (int)(price*quantity*0.9):price*quantity;
	//각 조건식이 참/거짓에 따라 결과값으로 사용될 값의 자리에 단순값이 아닌 수식 사용 가능.
	System.out.println("총 가격 : " +total);
	}
	}
	//출력결과
    상품의 가격 : 300
	상품의 개수 : 6
	총 가격 : 1620
    
    10-3)
    
	import java.util.Scanner;

	public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char grade;
		System.out.println("점수를 입력하세요.");
		int score=scan.nextInt();
		//grade =score>80? (score>70?'A':'B'):(score>40?'C':'D');
		grade =score>90? 'A':score>=70?'B':score>60?'C':'D';
		String result =score>90? "A입니다.":"B입니다.";
		System.out.println("성적 : "+ grade);
		System.out.println(result);
		}
	}
    //출력결과
    점수를 입력하세요.
	70
	성적 : B
	B입니다.

---


####비트연산자
AND(&) : 피연산자 양 쪽 모두 1이면 결과 1
OR(|) :피연산자 한쪽 값이 1이면 결과 1
XOR(^) : 피연산자의 값이 서로 다를 때 결과 1



####암호화
암호 알고리즘 : 어떤 연산을 했는지 알려주지만 키가 필요.
ex) AES 암호화
공개키 암호화 알고리즘 : 
ex)공인인증서


####EXAMPLES
	(1) 윤년계산 - 연도를 출력받아 윤년여부를 판단 후 출력
    import java.util.Scanner;

	public class One {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	System.out.println("년도를 입력하세요.");
	int year= scan.nextInt();
	String result= (year%4==0&&year%100!=0)||year%400==0? "Yes":"No";
    //boolean result=(year%4==0&&year%100!=0)||(year%400==0); 
	=>윤년여부 판단은 관계, 논리연산 조합으로 연산 결과가 T/F값이므로 boolean 형태 사용
	}
	System.out.printf("%d년은 윤년인가요? %s", year,result);
	}
	}
	//출력결과
	년도를 입력하세요.
	2020
	2020년은 윤년인가요? Yes

	(2)화폐개수 -
    import java.util.Scanner;

	public class One {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("금액을 입력하세요.");
		int price = scan.nextInt();
		int man=price/10000;
		int thun=(price%10000)/1000;
		int obaek=(price%10000)%1000/500;
		int baek=(price%10000)%1000%500/100;
		int sim=(price%10000)%1000%500%100/10;
		System.out.printf("만원 : %d 개\n",man);
		System.out.printf("천원 : %d 개\n",thun);
		System.out.printf("오백원 : %d 개\n",obaek);
		System.out.printf("백원 : %d 개\n",baek);
		System.out.printf("십원 : %d 개\n",sim);
	}
	}
    //출력결과\
    금액을 입력하세요.
	17810
	만원 : 1 개
	천원 : 7 개
	오백원 : 1 개
	백원 : 3 개
	십원 : 1 개
    
    (3)3개 중 제일 큰값
    import java.util.Scanner;

	public class One {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 3개 입력하세요.");
			int a=scan.nextInt();
			int b=scan.nextInt();
			int c=scan.nextInt();
			int max=(a>b&&a>c)? a:(b>c&&b>a)?b:c;
			System.out.println("제일 큰 값 : " +max);
	}
	}

    //출력결과
    숫자를 3개 입력하세요.
	45 23 87
	제일 큰 값 : 87
    
    (4)중간값
    import java.util.Scanner;

	public class One {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 3개 입력하세요.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int middle = (a > b && a < c || a > c && a < b) ? a 
        			: (b > c && b > a || b > a && b > c) ? b : c;
        //int middle =(a>b? a:b)<(b>c? b:c)? (a>b? a:b) 
					:(b>c? b:c)<(a>c? a:c)? (b>c? b:c) : (a>c? a:c);
         =>각각 a.b.c를 비교한 후 나온 값을 서로 다시 비교하여 작은 것이 중간값.
        //쌤 풀이
        //int tmp1=a>b? a:b;
		//int tmp2=b>c? b:c;
		//int tmp3=c>a? c:a;
        //int result=tmp1>tmp2? (tmp2>tmp3? tmp3: tmp2) : (tmp1>tmp3? tmp3:tmp1);
		System.out.println("중간값 : " +middle);
	}
	}
	//출력결과
    숫자를 3개 입력하세요.
	32 13 17
	중간값 : 17
    //출력결과2
    숫자를 3개 입력하세요.
	25 10 30
	중간값 : 25

