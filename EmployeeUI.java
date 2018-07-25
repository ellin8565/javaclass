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
			} else if (userSel == 4) {
				em.save();
			}
		}
	}

	// UI로서 기능 내가 구현, 그 이외 em 것 사용
	public void print() {
		System.out.println("1. 직원 등록");
		System.out.println("2. 최고급여직원");
		System.out.println("3. 평균 급여");
		System.out.println("4. 세이브");
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
