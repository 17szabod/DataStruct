package assignment6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class CompanyDemo {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader EReader = new FileReader("EMPLOYEE.txt");
		Scanner scanEmps = new Scanner(EReader);
		scanEmps.nextLine();
		HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
		while (scanEmps.hasNextLine()) {
			int y = 0;
			String name;
			int ssn;
			String date;
			String address;
			int salary;
			int superSSN;
			int depNum;
			String holdIt;
			String toProc = scanEmps.nextLine();
			for (int x = 0; x < toProc.length(); x++) {
				String temp = toProc.substring(x, x + 1);
				if (temp.equals(",")) {
					y++;
					switch (y) {
					case 2:
						name = holdIt;
					case 3:
						ssn = Integer.parseInt(holdIt);
					case 4:
						date = holdIt;
					case 5:
						address = holdIt;
					case 6:
						salary = Integer.parseInt(holdIt);
					case 7:
						superSSN = Integer.parseInt(holdIt);
					case 8:
						depNum = Integer.parseInt(holdIt);
					}
				}
				else {
					holdIt += temp;
				}
			}
			Employee newGuy = new Employee(ssn, address, date, depNum, superSSN, name);
			employees.put(ssn, newGuy);
		}
		FileReader DReader = new FileReader("DEPARTMENT.txt");
		Scanner scanDeps = new Scanner(DReader);
		scanDeps.nextLine();
		HashMap<Integer, Department> departments = new HashMap<Integer, Department>();
		while (scanDeps.hasNextLine()) {
			int y = 0;
			String name;
			int dNum;
			int mgrSSN;
			String date;
			String holdIt;
			String toProc = scanDeps.nextLine();
			for (int x = 0; x < toProc.length(); x++) {
				String temp = toProc.substring(x, x + 1);
				if (temp.equals(",")) {
					y++;
					switch (y) {
					case 1:
						name = holdIt;
					case 2:
						dNum = Integer.parseInt(holdIt);
					case 3:
						mgrSSN = Integer.parseInt(holdIt);
					case 4:
						date = holdIt;
					}
				}
				else {
					holdIt += temp;
				}
			}
			Department newDep = new Department(name, dNum, mgrSSN, date);
			departments.put(dNum, newDep);
		}
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Choice 1 : Given an employee SSN as input, list the department name and number that the employee works for");
			System.out.println("Choice 2 : Given an employee SSN as input, list all supervisors");			 
		    System.out.println("Choice 3 : Quit the program");
		    int choice = in.nextInt();
		    switch (choice) {
		    case 1:
		    	System.out.println("Please enter employee social security number");
		    	int ssn = in.nextInt();
		    	Employee thisGuy = employees.get(ssn);
		    	System.out.println("Department name: " + departments.get(thisGuy.getDepartmentNumber()).getName());
		    	System.out.println("Department number: " + thisGuy.getDepartmentNumber());
		    case 2:
		    	System.out.println("Please enter employee social security number");
		    	int socSecNum = in.nextInt();
		    	getSupervisor(socSecNum, employees);
		    case 3:
		    	done = true;
		    default: 
		    	System.out.println("Invalid entry");
		    }
		}

	}
	
	public static int getSupervisor(int ssn, HashMap<Integer, Employee> employees) {
		System.out.println(employees.get(ssn).getName());
		if (ssn != 0) {
			getSupervisor(ssn, employees);
		}
	}

}
