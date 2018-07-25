package employeepack;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Employees implements Serializable {
	Scanner scan = new Scanner(System.in);
	ArrayList<Employee> Employees;

	public Employees() {
		Employees = new ArrayList<>();
		;
	}

//직원등록
//주석처리 상태= ui 기능과 같이있음

	public void AddEmployee(String name, int age, int salary) {
		Employee e = new Employee(name, age, salary);
		Employees.add(e);
	}

//급여多

	public Employee getMaxSal() {
		Employee e = null;
		int maxSal = 0;
		for (int i = 0; i < Employees.size(); i++) {
			if (Employees.get(i).getSalary() < maxSal)
				maxSal = Employees.get(i).getSalary();
			e = Employees.get(i);
		}
		return e;
	}

	public int average() {
		int average = 0;
		int sum = 0;
		for (int i = 0; i < Employees.size(); i++) {
			sum += Employees.get(i).getSalary();
		}
		return average = sum / Employees.size();
		// System.out.println("급여 평균: "+average);
	}

	public void save() {

		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream("mydata.dat"));
//	          Account a = new Account("1234","Hong",500);
			oo.writeObject(Employees);
			oo.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (oo != null)
					oo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void load() {
	         
	        ObjectInputStream oi = null;
	        try {
	            oi = new ObjectInputStream(new FileInputStream("mydata.dat"));
	            Employees = (ArrayList<Employee>)oi.readObject();
	             
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
//	          e.printStackTrace();
	            System.out.println("파일이 존재하지 않습니다.");
	            Employees = new ArrayList<>();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                if(oi != null)
	                    oi.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	         

}
}
