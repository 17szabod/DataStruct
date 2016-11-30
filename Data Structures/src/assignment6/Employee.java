package assignment6;

public class Employee {
	private String name;
	private int ssn;
	private String address;
	private int salary;
	private boolean male;
	private String bDate;
	private int depNum;
	private int supSSN;
	
	public Employee(int ssn, String address, String bDate, int depNum, int supSSN, String name, int salary) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.bDate = bDate;
		this.depNum = depNum;
		this.supSSN = supSSN;
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSSN() {
		return ssn;
	}
	
	public String getAddress() {
		return address;
	}
	
	public boolean isMale() {
		return male;
	}
	
	public String getBirthday() {
		return bDate;
	}
	
	public int getDepartmentNumber() {
		return depNum;
	}
	
	public int getSupervisorSSN() {
		return supSSN;
	}
}