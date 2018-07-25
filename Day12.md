#DAY12
___

###연습
	1)
    package employeepack;

	public class Employee{
		private String name;
		private int age;
		private int salary;

		public Employee(String name, int age, int salary) {
			this.name = name;
			this.age = age;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
	
	
	}
    
    ___
    package employeepack;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class Employees {
	Scanner scan= new Scanner(System.in);
	ArrayList<Employee> Employees;
	public Employees() {
		Employees=new ArrayList<>();;
	}
	public void run() {
		int userSel=-1;
	
		while(userSel!=0) {
			print();	
			userSel=Integer.parseInt(scan.nextLine());
			if(userSel==1) {AddEmployee();}
			else if(userSel==2) { mostSalary();}
			else if(userSel==3) {average();}
	
		}
	}
	public void print() {
		System.out.println("1. 직원 정보입력");
		System.out.println("2. 급여가 제일 많은 직원");
		System.out.println("3. 평균 급여");
		System.out.println("0. 종료");
	}
	//직원등록
	public void AddEmployee() {
		System.out.println("이름입력 :");
		String name=scan.nextLine();
		System.out.println("나이입력 :");
		int age=Integer.parseInt(scan.nextLine());
		System.out.println("급여입력 :");
		int salary=Integer.parseInt(scan.nextLine());
		Employee em=new Employee(name, age, salary);
		Employees.add(em);
	}

	//급여多
	public void mostSalary() {
		//각 직원들 salary 비교
		int maxIndex=0;
		for(int i=0;i<Employees.size();i++) {
			if(Employees.get(maxIndex).getSalary()<Employees.get(i).getSalary())
				maxIndex=i;
			}
		System.out.println(Employees.get(maxIndex).toString());	
	}

	//평균
	public void average() {
		int average=0;
		int sum=0;
		for(int i=0; i<Employees.size();i++) {
			sum+=Employees.get(i).getSalary();
		}
		average=sum/Employees.size();
		System.out.println("급여 평균: "+average);
	}
	}
    ___
    package employeepack;

	public class Test {
	public static void main(String[] args) {
	Employees ems=new Employees();
	ems.run();
	}
	}
    
    
###UI 분리
	
    2)
    package employeepack;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class Employees {
	Scanner scan= new Scanner(System.in);
	ArrayList<Employee> Employees;
	public Employees() {
		Employees=new ArrayList<>();;
	}
	
	//직원등록
	//주석처리 상태= ui 기능과 같이있음

	public void AddEmployee(String name, int age, int salary) {
		//입력은 다른 놈이
		Employee e=new Employee(name, age, salary);
		Employees.add(e);
	}

	//급여多

	public Employee getMaxSal() {
		Employee e=null;
		int maxSal=0;
		for(int i=0;i<Employees.size();i++) {
			if(Employees.get(i).getSalary()<maxSal)
				maxSal=Employees.get(i).getSalary();
				e=Employees.get(i);
			}	
	return e;
	}
		
	
	//평균
	//UI와 분리
	public int average() {
		int average=0;
		int sum=0;
		for(int i=0; i<Employees.size();i++) {
			sum+=Employees.get(i).getSalary();
		}
		return average=sum/Employees.size();
		//System.out.println("급여 평균: "+average);
	}
	}
    ___
    package employeepack;

	import java.util.Scanner;

	public class EmployeeUI {
	private Employees em;
	Scanner scan = new Scanner(System.in);

	public EmployeeUI() {
		em = new Employees();
	}

	// 전체 UI 흐름 기능
	public void start() {
		int userSel = -1;
		while (userSel != 0) {
			print();
			userSel = Integer.parseInt(scan.nextLine());
			if (userSel == 1) {
				addEmployee();
			} else if (userSel == 2) {
				printMaxsal();
			} else if (userSel == 3) {
				printAver();
			}

		}
	}

	// UI로서 기능 내가 구현, 그 이외 em 것 사용
	public void print() {
		System.out.println("1. 직원 등록");
		System.out.println("2. 최고급여직원");
		System.out.println("3. 평균 급여");
		System.out.println("0. 종료");
	}

	public void addEmployee() {
		System.out.println("이름입력 :");
		String name = scan.nextLine();
		System.out.println("나이입력 :");
		int age = Integer.parseInt(scan.nextLine());
		System.out.println("급여입력 :");
		int salary = Integer.parseInt(scan.nextLine());
		em.AddEmployee(name, age, salary);
	}

	// 최대 연봉 직원 출력
	public void printMaxsal() {
		System.out.println(em.getMaxSal());// return e=>toString
	}

	public void printAver() {
		System.out.println("전체 급여 평균 :" + em.average());
	}
	}
___
	package employeepack;

	public class Test {
	public static void main(String[] args) {
	EmployeeUI ems=new EmployeeUI();
	ems.start();
	}
	}

---


###입출력
>우리 프로세스 밖의 어딘가와 데이터를 주고 받는 것
>- 파일 입출력 : 파일을 목적지를 데이터로 주고 받음
>- 네트워크 입출력 : 네트워크카드를 목적지로 데이터를 주고 받음

###스트림
>**순서가 있는** 데이터의 연속적인 흐름 
>
>- 바이트 스트림 : 바이트로 읽고 쓰는 최상위 추상 클래스
>- 문자스트림 : 
>
>데이터 싱크 스트림
>
>

---
	2)파일 입력

	package stream;

	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	public class FileStreamTest {
	public static void main(String[] args) {
		// 특정 파일에 데이터를 쓸 거임
		// fileoutputStream 객체
		// 1.목적지가 파일인 out putstream생성
		// 그녀셕은 fileouputstream 클래스=>객체 생성 필요
		// 목적지는 생성자가
		// 2.츨력하고자 하는 데이터 분지
		// 3.write 메소드를 통해서ㅓ에이더 출력
		// 4.stream 닫기(close)=>열어 두는 거 위험
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("myfile.txt");// 목적지지정 =>예외발생=>try/catch
			// 0~9까지의 숫자를 바이트로 파일에 입력
			for (int i = 65; i < 123; i++)
				fo.write(i); // 아스키 코드 출력
		} catch (FileNotFoundException e) { // 파일이 없을 경우
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} finally { // 반드시 실행
			try {
				if (fo != null)
					fo.close(); // 객체를 생성하다 오류가 났을 수 있음
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	}
    
	2-1)출력
    package stream;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	public class FileStreamTest2 {
	//읽어오기
	//1. 목적지 지정fileInputStream객체 생성
	//2.read()
	//3. stream 닫음
	public static void main(String[] args) {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("myfile.txt");
			int data;
			while ((data = fi.read()) != -1) {
				// read(): the next byte of data, or -1 if the end of the file is reached.
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 반드시 실행
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	}
    
    3)
    package employeepack;

	import java.util.ArrayList;
	import java.util.Scanner;

	public class Employees {
	Scanner scan= new Scanner(System.in);
	ArrayList<Employee> Employees;
	public Employees() {
		Employees=new ArrayList<>();;
	}
	
	//직원등록
	public void AddEmployee(String name, int age, int salary) {
		//입력은 다른 놈이
		Employee e=new Employee(name, age, salary);
		Employees.add(e);
	}

	//급여多

	public Employee getMaxSal() {
		Employee e=null;
		int maxSal=0;
		for(int i=0;i<Employees.size();i++) {
			if(Employees.get(i).getSalary()<maxSal)
				maxSal=Employees.get(i).getSalary();
				e=Employees.get(i);
			}	
	return e;
	}

	//평균
	//UI와 분리
	public int average() {
		int average=0;
		int sum=0;
		for(int i=0; i<Employees.size();i++) {
			sum+=Employees.get(i).getSalary();
		}
		return average=sum/Employees.size();
		//System.out.println("급여 평균: "+average);
	}
	}
    //출력결과
    



###buffer
>한번에 읽어드릴 수 있도록
>입출력이 일어나는 두 대상의 속도가 다를 수 있으므로
>
>

	3)
    package stream;

	import java.io.BufferedOutputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	
	public class BufferedStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bo = null;
		try {
			FileOutputStream fo = new FileOutputStream("myfile2.txt");
			bo = new BufferedOutputStream(fo); // fileOutputStream fo를 받음
			for (int i = 65; i < 123; i++) //아스키 코드
				bo.write(i);
			bo.flush(); // 바가지 비우기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 마지막 것만 닫으면 같이 닫힘
			if (bo != null)
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	}
    //출력결과
    ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz

###Data
>

###직렬화
>implement serializ
objectin/output : 객체단위를 읽고 쓰는 것=>
객체가 읽고 써지기 위해서는 직렬화가 될 수 있어야하고 직렬화가 가능한 클래스는 serialize인터페이스(추상메소드 없음)를 구현