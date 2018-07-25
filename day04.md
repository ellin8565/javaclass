#Day04

p.161~163 패턴 흐름 찾기.
###Chapter.배열
-**같은 타입**의 여러 변수들의 모임.
-같은 배열로 묶인 변수들은 모두 메모리상에 인접해서 만들어짐.
(+각개로 만들어진 각각의 변수들은 메모시상에 여기저기 산재해서 생성)
-**int[] arr **: int 배열의 주소를 기억할 arr(참조변수) arr은 배열의 주소를 저장
-**arr=new int[] **: int 형 배열을 힙영역에 생성. 생성된 배열의 주소를 arr에 저장(배열은 개수가 유동적이므로 힙영역 생성, 이름을 붙일 수 없음.)
-힙영역에 생성되는 데이터는 자신의 타입에 맞는 데이터로 초기화 되어있다.
- - -

	1)
	import java.util.Scanner;

	public class Floewstar {
	public static void main(String[] args) {
		int[] salary = new int[2];
		Scanner scan = new Scanner(System.in);
		System.out.printf("직원1의 월급을 입력하시오 : ");
		salary[0] = scan.nextInt();
		System.out.printf("직원2의 월급을 입력하시오 : ");
		salary[1] = scan.nextInt();
		System.out.println("직원1의 월급은 " + salary[0]);
		System.out.println("직원1의 월급은 " + salary[1]);
	}
	}

####*배열이름.length
-배열의 길이 정보, 자바에서는 JVM이 배열의 길이를 별도로 관리

---
	2)
    import java.util.Scanner;

	public class Floewstar {
	public static void main(String[] args) {
		final int STUDENTS=5;
		int total =0;
		Scanner scan=new Scanner(System.in);
		int[] scores=new int[STUDENTS];
		for (int i=0;i<STUDENTS;i++) {
			System.out.printf("성적을 입력하시오. : " );
			scores[i]=scan.nextInt(); //입력하고 줄바꿈...
		}
		for (int i=0;i<STUDENTS;i++) total+=scores[i]; 
		System.out.println("평균성적은 "+total/STUDENTS+"입니다.");
	}
	}
    
    2-1)
    import java.util.Scanner;

	public class ScoreTest {
	public static void main(String[] args) {
	int total=0;
	int size;
	Scanner scan=new Scanner(System.in);
	System.out.printf("배열의 크기를 입력하시오.: ");
	size =scan.nextInt();
	int[] scores=new int[size];
	for (int i=0;i<scores.length;i++) {
		System.out.printf("성적을 입력하시오. : " );
		scores[i]=scan.nextInt(); //입력하고 줄바꿈...
	}
	for (int i=0;i<scores.length;i++)	total+=scores[i];
	System.out.println("평균 : "+total/scores.length);
	}
	}

####*배열의 초기화
-int[ ] score=new int[ ] {50,60,70};
-int[ ] score={50,60,70} : new int[ ] 생략가능, 하지만 배열의 선언과 생성을 따로할 경우 생략할 수 없다.


	3)
    public class MaxPr {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 2, 8, 1, 4 };
		int a = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (a > arr[i])
				continue;
			else
				a = arr[i];
		}
		System.out.println("MAX : " + a);
	}
	}
    //출력결과
    MAX : 8

	3-1)
    
	public class MaxPr {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 2, 8, 1, 4 };
		int a = arr[0];
		for (int ar : arr){
			if (a > ar)
				continue;
			else
				a = ar;
		}
		System.out.println("MAX : " + a);
	}
	}
    
    3-2)
    
	public class MaxPr {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 2, 8, 1, 4 };
		int a = arr[0];
		int maxN = 0;
		for (int i = 0; i < arr.length; i++) {
			if (a > arr[i])
				continue;
			else {
				a = arr[i];
				maxN = i + 1;
			}
		}
		System.out.println("몇 번째? " + maxN);
		System.out.println("MAX : " + a);
	}
	}
    //출력결과
    몇 번째? 5
	MAX : 8
---    

+정렬과 인덱싱이 되어있으면 데이터를 더 빨리 찾음. 인덱스는 사람들이 지정

---
	4) 내림차순 정렬 : 처음 숫자를 제일크다고 가정 후 비교하여 가장 큰 것과 자리를 바꿔서 차례대로 나오도록
    public class Pibot {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 2, 8, 1, 4 };
		for (int j=0;j<arr.length;j++) { 
			int max=arr[j];
			int maxIndex=j;
			for (int i=j; i<arr.length;i++) {
				if(max<arr[i]) {
					max=arr[i];
					maxIndex=i; 
				}
			}
			int tmp=arr[j];
			arr[j]=arr[maxIndex];
			arr[maxIndex]=tmp;
	}
		for (int a :arr)	System.out.println(a);
	}
	}
	https://www.dropbox.com/home/____mulcam18_2/_capture?preview=iccack70%40gmail.com_20180706_111041.png
    4-1) 내가 해보기...
    
	public class Sorting2 {
	public static void main(String[] args) {
	int[] arr = { 5, 3, 7, 2, 8, 1, 4 };

	for (int j=0;j<arr.length;j++) {
		int max=arr[j]; //최대값으로 가정
		int num=j;	
	for (int i=j;i<arr.length;i++) {
		if (max < arr[i]) {
			max = arr[i]; //제일 큰수
			num=i; //큰수의 위치
		}
		int a=arr[j];
		arr[j]=arr[num]; //1. [0] 과 [5] 자리 숫자 바꿈.
		arr[num]=a; //자리 바꿈...
		//8 3 7 2 5 1 4
	}
	}
	for(int a: arr)
	System.out.println(a);
	}
	}


    
    
---
	5)

	public class ArrayEx {
	public static void main(String[] args) {
	int sum=0;
	float average= 0f;
	int[] score= {100,88,100,100,90};
	for (int i=0;i<score.length;i++) {
		sum+=score[i];
	}
	average=sum/(float)score.length;
	System.out.println("sum " +sum);
	System.out.println("average " + average);
	}
	}

    //출력결과
    sum 478
	average 95.6
    
---
	6)버블소팅 : n-1번째과 n번째를 비교하여 n번째가 더 작으면 자리 바꾸기.
    
	public class Bubblesor {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 7, 2 };
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int b = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = b;
				}
			}
		}
		for (int a: arr) System.out.print(a+ " ");
	}
	}
    //출력결과
    2 3 5 7 
---

+참고 -퀵 정렬

####*2차원 배열
-**int[ ] [ ]**
-정수 배열의 배열의 위치 기억

	(7)
	public class TwoArr {
	public static void main(String[] args) {
		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 } };

		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++)
				System.out.printf("score[%d][%d]=%d\n", i, j, score[i][j]);

		}
		for (int[] tmp : score) { //p.216 그림
			for (int i : tmp)
				sum += i;
		}
		System.out.println("sum: " + sum);
	}
	}
    
    8)
	public class Test {
	public static void main(String[] args) {
	int[][] arr=new int[3][];
	//int[] arr=new int[3]; =>arr은 정수 배열의 위치 저장

	arr[0]= new int[2];
	arr[1]=new int[3];
	//arr[0][0]=10;
	for (int[] a: arr) System.out.println(a);
	for (int[] a: arr) System.out.println(a.length);
	//null은 주소값이 없는 상태
	//null은 일반적으로 사용되는 IT용어
	//arr[2] : 참조변수가 아무것도 참조하고 있지 않음.=>에러(NullPoninterException)
	}
	}
    //출력결과
    [I@35f983a6
	[I@7f690630
	null
	2
	3
    Exception in thread "main" java.lang.NullPointerException
	at Test.main(Test.java:11)
    
    
---
	9)행렬 더하기
	public class Matrix {
	public static void main(String[] args) {
		int[][] matrix1 = { { 2, 3 }, { 4, 2 } };
		int[][] matrix2 = { { 4, 1 }, { 3, 7 } };
		int[][] result = new int[2][2]; // 결과값을 저장할 배열
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++)
				result[i][j] = matrix1[i][j] + matrix2[i][j];
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <  result.length; j++)
				System.out.print(result[i][j]+" ");
                //System.out.print(result); ==>주소값 출력
			System.out.println("");
		}
	}
	}
    //출력결과
    6 4 
	7 9 
---
+변수명 한번에 바꾸기 : refactor- rename 

	10)행렬 곱
    
	public class MatrixM {
	public static void main(String[] args) {
		int[][] a = { { 2, 3 }, { 4, 2 } };
		int[][] b = { { 4, 1 }, { 3, 7 } };
		int[][] r = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < r.length; j++)
				// r[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0]
				// r[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1]
				// r[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0]
				// r[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1]
				r[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < r.length; j++)
				System.out.print(r[i][j] + " ");
			System.out.println("");
		}
	}
	}
---
####Practice
	11)
	public class Examplpr {
	public static void main(String[] args) {
	int[] numArr=new int[10];
	 for (int i=0;i<numArr.length;i++) {
		 numArr[i]=i;
		 System.out.print(numArr[i]);
	 }
	 System.out.println();
	 for(int i=0;i<100;i++) {
		 int n=(int)(Math.random()*10);//랜덤
		 int tmp=numArr[0];
		 numArr[0]=numArr[n]; //위치지정 숫자 랜덤.
		 numArr[n]=tmp;
	 }
	 for(int i=0;i<numArr.length;i++) System.out.print(numArr[i]);
	}
	}
	//
    0123456789
	7930286145
	
---
    12)
	public class Examplpr {
	public static void main(String[] args) {
	int[][] score = { {100,100,100},{20,20,20},{30,30,30},{40,40,40} };
	int korTotal =0, engTotal=0,mathTotal=0; //각 과목 총점
	System.out.println("번호 국어 영어 수학 총점 평균");
	System.out.println();
	 for (int i=0;i<score.length;i++) {
		 int sum=0; //개인별
		 float avg=0.0f; //개인별 평균
		 
		 korTotal+=score[i][0];
		 engTotal+=score[i][0];
		 mathTotal+=score[i][0];
		 System.out.printf("%3d", i+1);
		 for (int j=0;j<score[i].length;j++) {
			 sum+=score[i][j];
			 System.out.printf("%5d",score[i][j]);
		 }
		 avg=sum/(float)score[i].length;
		 System.out.printf("%5d %5.1f\n", sum,avg);
	 }
	}
	}
    //출력결과
    번호 국어 영어 수학 총점 평균
  	1  100  100  100  300 100.0
 	2   20   20   20   60  20.0
 	3   30   30   30   90  30.0
 	4   40   40   40  120  40.0
    
---
	13)빙고게임 p223

    import java.util.Scanner;

	public class Examplpr {
	public static void main(String[] args) {
		final int SIZE = 5;
		int x = 0, y = 0, num = 0;

		int[][] bingo = new int[SIZE][SIZE];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++)
				bingo[i][j] = i * SIZE + j + 1;// 1에서 SIZE*SIZE 까지의 숫자
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				x = (int) (Math.random() * SIZE);
				y = (int) (Math.random() * SIZE);

				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
				// 배열된 값 뒤섞기
			}
		}
		do {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++)
					System.out.printf("%2d ", bingo[i][j]); //섞인 빙고 출력
				System.out.println();
			}
			System.out.println();
			System.out.printf("1~%d의 숫자 입력: ", SIZE * SIZE);
			String tmp = scan.nextLine();
			num = Integer.parseInt(tmp);

			outer: for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						break outer;
					}
				}
			}
		} while (num != 0);

	}
	}
---    
    14)중복없이 랜덤(미완)
    
	public class Dk {
	public static void main(String[] args) {
	int[] arr= {7,3,6,7,3,3};
	for (int j = 0; j < arr.length; j++) {
		for (int i = j + 1; i < arr.length; i++) {
			if (arr[j] == arr[i]) {
					int x = (int) (Math.random() * 45) + 1;
					if (arr[i] != x) {
						arr[j] = x;
						break;
					} else
						continue;
				}
		}
	}
	System.out.println("후:");
	for (int ar : arr)
		System.out.printf("%d ", ar);
}
}








