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
			String name = "";
			int ssn = 0;
			String date = "";
			String address = "";
			int salary = 0;
			int superSSN = 0;
			int depNum = 0;
			String holdIt = "";
			String toProc = scanEmps.nextLine();
			while (toProc.contains(",,")) {
				toProc = toProc.replace(",,", ",0,");
			}
			for (int x = 0; x < toProc.length(); x++) {
				String temp = toProc.substring(x, x + 1);
				if (temp.equals(",")) {
					y++;
					switch (y) {
					case 2:
						name = holdIt;
						holdIt = "";
					case 3:
						ssn = Integer.parseInt(holdIt);
						holdIt = "";
					case 4:
						date = holdIt;
						holdIt = "";
					case 7:
						address = holdIt;
						holdIt = "";
					case 8:
						salary = Integer.parseInt(holdIt);
						holdIt = "";
					case 9:
						superSSN = Integer.parseInt(holdIt);
						holdIt = "";
					case 10:
						depNum = Integer.parseInt(holdIt);
						holdIt = "";
					default:
						holdIt += temp;
					}
				}
				else {
					holdIt += temp;
				}
			}
			Employee newGuy = new Employee(ssn, address, date, depNum, superSSN, name, salary);
			employees.put(ssn, newGuy);
		}
		FileReader DReader = new FileReader("DEPARTMENT.txt");
		Scanner scanDeps = new Scanner(DReader);
		scanDeps.nextLine();
		HashMap<Integer, Department> departments = new HashMap<Integer, Department>();
		while (scanDeps.hasNextLine()) {
			int y = 0;
			String name = null;
			int dNum = 0;
			int mgrSSN = 0;
			String date = null;
			String holdIt = null;
			String toProc = scanDeps.nextLine();
			if (toProc.contains(",,")) {
				toProc.replace(",,", ",0,");
			}
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
		if (employees.get(ssn).getSupervisorSSN() != 0) {
			getSupervisor(employees.get(ssn).getSupervisorSSN(), employees);
		}
		return employees.get(ssn).getSupervisorSSN();
	}

}