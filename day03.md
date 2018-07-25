####조건문
-조건식의 연산결과에 따라 실행할 문장이 달라져서 프로그램의 실행흐름 제어
-if(조건식) else : 조건식이 참이면 괄호 안의 문장을 수행. { }가 없을 경우 바로 아래 코드만 수행.
-switch case : 정수 혹은 문자열 변수를 받아 그 값에 따라 일치하는 case위치로 명령실행위치가 이동하여 명령 수행.

	1)
	public class Flow {
	public static void main(String[] args) {
		System.out.println("시험을 본다");
		int score=60;
		if(score>70) System.out.println("집");
		System.out.println("씻고 잔다");
	}
	}
    //출력결과
    시험을 본다
	씻고 잔다
    
    1-1)
	public class Test {
	public static void main(String[] args) {
		System.out.println("시험을 본다");
		int score=60;
		char grade;
		if(score>90) grade='A';
		else if (score>80)  grade='B';
		else if (score>70)  grade='C';
		else if (score>60)  grade='D';
		else  grade='F';
		System.out.println("성적 : " +grade);
	}
	}
    //출력결과
    시험을 본다
	성적 : F

    1-2)
    import java.util.Scanner;

	public class Flow {
	public static void main(String[] args) {
		int input;
		System.out.printf("숫자 1개 입력 : ");
		Scanner scan = new Scanner(System.in);
		String tmp = scan.nextLine();
        // nextLine :한 줄 단위로 입력받음.엔터 포함
        // nextInt : 숫자만 포함. 엔터 포함하지 않음.
		input = Integer.parseInt(tmp);
		if (input == 0) {
			System.out.println("입력하신 숫자는 0입니다.");
		}
		if (input != 0)
			System.out.println("입력하신 숫자는 0이 아닙니다.");
		System.out.printf("입력한 숫자 : %d", input);
	}
	}
    //출력결과
	숫자 1개 입력 : 5
	입력하신 숫자는 0이 아닙니다.
	입력한 숫자 : 5

**+변수 특징 : 변수는 자신이 속한 블락{ } 내에서만 유효.**

	2)
	public class block {
	public static void main(String[] args) {
	int input;
	if (input == 0) {
		System.out.println("입력하신 숫자는 0입니다.");
		int block=1;
	}
	System.out.println(block);//에러 =>if 문 내에서만 유효.
	}
	}
---

	3)
	import java.util.Scanner;

	public class Tax {
	public static void main(String[] args) {
		int income;
		int tax;
		System.out.printf("과세 표준 금액을 입력하세요.");
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		if (income <= 1000)
			tax = (int) (0.09 * income);
		else if (income <= 4000)
			tax = (int) (0.18 * income);
		else if (income < 8000)
			tax = (int) (0.27 * income);
		else
			tax = (int) (0.36 * income);
		System.out.println("소득세는 " + tax + "원 입니다.");
	}
	}
    //출력결과
    과세 표준 금액을 입력하세요.7000
	소득세는 1890원 입니다.
    
---
	4)SwitchEx
	public class SwitchEx {
	public static void main(String[] args) {
		// System.out.println(Math.abs(-5));// 절댓값
		// System.out.println(Math.random());
		// random : 0.0과 1.0 사이 범위에 속하는 하나의 double값을 반환(1.0 포함 X)
		// System.out.println((int)(Math.random()*10)+1); //1에서 10까지
		int number = (int) (Math.random() * 5) + 1;
		switch (number) {
		case 1:
			System.out.println("랜덤값 : " + number);
			break;
		case 2:
			System.out.println("랜덤값 : " + number);
			break;
		case 3:
			System.out.println("랜덤값 : " + number);
			break;
		case 4:
			System.out.println("랜덤값 : " + number);
			break;
		default:
			System.out.println("default : " + number);
			break;
		}
	}
	}

	//출력결과
    default : 5
    
    4-1)
    import java.util.Scanner;

	public class SwitchEx {
	public static void main(String[] args) {
		System.out.println("현재 월 입력 : ");
		Scanner scanner = new Scanner(System.in);
		int month =scanner.nextInt();
		 switch (month) {
		 case 3: case 4: case 5: 
			 System.out.println("봄");
			 break;
		 case 6: case 7: case 8 :
			 System.out.println("여름");
			 break;
		 case 9: case 10: case 11 :
			 System.out.println("가을");
			 break;
		 case 12: case 1: case 2 :
			 System.out.println("겨울");
			 break;
		 }
	}
	}
	//출력결과
    현재 월 입력 : 
	8
	여름
---
	5)
    import java.util.Scanner;

	public class SwitchRock {
	public static void main(String[] args) {
		System.out.println("가위(1),바위(2), 보(3) 중 하나를 입력");
		Scanner scan = new Scanner(System.in);
		int user = scan.nextInt();
		int com = (int) (Math.random() * 3 + 1); //1~3
		System.out.println("당신은 " + user + "입니다.");
		System.out.println("컴은 " + com + "입니다.");

		switch (user - com) {
		case 0:
			System.out.println("비겼습니다.");
			break;
		case 1:		case -2:
			System.out.println("당신이 이겼습니다.");
			break;
		case 2:		case -1:
			System.out.println("당신이 졌습니다.");
			break;
		}
	}
	}

    //출력결과
    가위(1),바위(2), 보(3) 중 하나를 입력
	3
	당신은 3입니다.
	컴은 2입니다.
	당신이 이겼습니다.
    
---
	6)
    public class FlowEx {
	public static void main(String[] args) {
		int number = (int) (Math.random() * 10) + 1;
		System.out.println("number : " + number);
		switch (number) {
		case 1:
			System.out.println("Bananas");
			break;
		case 2:
			System.out.println("Oranges");
			break;
		case 3:
			System.out.println("Pears"); // 3 : pears, apples, plums
		case 4:
			System.out.println("Apples");// 4 : apples, plums =>break 없음
		case 5:
			System.out.println("Plums");
			break;
         //if 만으로 
		case 6:
			System.out.println("Pineapples");
			break;
		case 7:
			System.out.println("No messages-ingore this case");
			break;
		default:
			System.out.println("Nuts");
			break;
		}
	}
	}
	//출력결과
    number : 4
	Apples
	Plums
    
####반복문
-특정문장들을 반복해서 수행
-while(조건식) : 조건이 참이면 조건식이 거짓이 될 때까지 블럭 내 문장 반복
-for : 초기화된 i-조건문 확인-코드 실행-증감식

	7)whileTest
	public class WhileTest {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 10) { //반복계수 : 조건에 사용된 변수
			System.out.println("i : " + i);
			i++; //반복계수의 변화
		}
	}
	}
    
    7-1)짝수만 출력
	public class WhileTest {
	public static void main(String[] args) {
		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0)
				System.out.println("i : " + i);
			i++;
		}
	}
	}
    //출력결과
    i : 2
	i : 4
	i : 6
	i : 8
	i : 10

---
	8)
    public class WhileEx {
	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		while (b <= 9) {
			int result = a * b;
			System.out.printf("%d * %d= %2d%n", a, b, result);
            //System.out.printf("2 * %d= %2d%n", b, result);
			b++;
		}
	}
	}
    //출력결과
	구구단 2단
    
    8-1)
    public class WhileEx {
	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		
		while (a <= 9) {
			while (b <= 9) {
				int result = a * b;
				System.out.printf("%d * %d= %2d%n", a, b, result);
				// System.out.printf("2 * %d= %2d%n", b, result);
				b++;
			}
			b = 1;
			a++;
		}
	}
	}
    //출력결과
    1~9단 
--- 
######유클리드 알고리즘 :  최대공약수를 구하는 알고리즘. 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.

    9)유클리드 알고리즘
    import java.util.Scanner;

	public class WhileEx {
	public static void main(String[] args) {
		int x, y;

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력 2개");
		x = scan.nextInt();
		y = scan.nextInt();
		while (y > 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		System.out.println("공약수 : " + x);
	}
	}
	//출력결과
    숫자 입력 2개
	24 6
	공약수 : 6
    
    10)줄 3개,연습
    
	public class Test {
	public static void main(String[] args) {
		int j = 1;
		while (j < 10) {
		int i = 1;
		while (i < 10) {
		System.out.printf("%d *%d=%2d \t %d *%d= %2d \t %d *%d= %2d \n",
        j, i, j *i, j+1 ,i, (j + 1) * i, j + 2, i,(j + 2) * i);
		i++;
		}
		j += 3;
		}
	}
	}
    
    10-1)
    	public class Test {
        public static void main(String[] args) {
		int j = 1;
		while (j <=7) {
		int i = 1;
		while (i <= 9) {
		System.out.printf("%d *%d=%2d ",j, i, j *i);
		System.out.printf("\t");
		System.out.printf("%d *%d=%2d ",j+1, i, (j+1) *i);
		System.out.printf("\t");
		System.out.printf("%d *%d=%2d ",j+2, i, (j+2) *i);
		System.out.printf("\n");
		i++;
		}
		j += 3;
		}
	}
	}
---
	11)do-while : 반복문 속에 변수가 있을 때
    import java.util.Scanner;

	public class Dowhile {
	public static void main(String[] args) {
	int answer=59;
	int guess;
	int tries=0;
	Scanner scan =new Scanner(System.in);
	do {
		System.out.print("정답 추측");
		guess=scan.nextInt();
		tries++;
		if (guess>answer) 
			System.out.println("제시한 정수가 높습니다.");
		if (guess<answer) 
			System.out.println("제시한 정수가 낮습니다.");
	}while(answer!=guess);
	System.out.println("축하합니다. 시도 횟수 : "+tries);
	}
	}
    //출력결과
    정답 추측 66
	제시한 정수가 높습니다.
	정답 추측 36
	제시한 정수가 낮습니다.
	정답 추측 59
	축하합니다. 시도 횟수 : 3
    
---
	12)for 문 3줄씩
	public class For3 {
	public static void main(String[] args) {
		for (int a = 1; a <= 9; a=a+3) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf(" %d * %d = %2d", a, i, a * i);
				System.out.printf("\t");
				System.out.printf(" %d * %d = %2d", a+1, i, (a+1)* i);
				System.out.printf("\t");
				System.out.printf(" %d * %d = %2d", a+2, i, (a+2)* i);
				System.out.printf("\n");
			}
		}
	}
	}
    
####break
-자신이 포함된 가장 가까운 반복문을 벗어난다.

####continue
-반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복 실행.






