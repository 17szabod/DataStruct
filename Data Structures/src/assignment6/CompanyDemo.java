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
			String temp = scanEmps.nextLine();
			while (temp.contains(",,")) {
				temp = temp.replace(",,", ",0,");
			}
			String[] lineData = temp.split(",");
			String tempAdd = lineData[4] + lineData[5] + lineData[6];
			Employee emp = new Employee(lineData[0] + " " + lineData[1], Integer.parseInt(lineData[2]), 
					lineData[3], tempAdd, Integer.parseInt(lineData[7]), Integer.parseInt(lineData[8])
					, Integer.parseInt(lineData[9]));
			employees.put(Integer.parseInt(lineData[2]), emp);
		}
		FileReader DReader = new FileReader("DEPARTMENT.txt");
		Scanner scanDeps = new Scanner(DReader);
		scanDeps.nextLine();
		HashMap<Integer, Department> departments = new HashMap<Integer, Department>();
		while (scanDeps.hasNextLine()) {
			String temp = scanDeps.nextLine();
			while (temp.contains(",,")) {
				temp = temp.replace(",,", ",0,");
			}
			String[] lineData = temp.split(",");
			Department newDep = new Department(lineData[0], Integer.parseInt(lineData[1]), Integer.parseInt(lineData[2]), lineData[3]);
			departments.put(Integer.parseInt(lineData[1]), newDep);
		}
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println();
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
		    	break;
		    case 2:
		    	System.out.println("Please enter employee social security number");
		    	int socSecNum = in.nextInt();
		    	getSupervisor(employees.get(socSecNum).getSupervisorSSN(), employees);
		    	break;
		    case 3:
		    	done = true;
		    	break;
		    default: 
		    	System.out.println("Invalid entry");
		    	break;
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