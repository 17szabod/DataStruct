package assignment6;

public class Department {
	private String name;
	private int num;
	private int managerSSN;
	private String stDate;
	
	public Department(String name, int num, int managerSSN, String stDate) {
		this.name = name;
		this.num = num;
		this.managerSSN = managerSSN;
		this.stDate = stDate;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return num;
	}
	
	public int getManager() {
		return managerSSN;
	}
	
	public String getStartDate() {
		return stDate;
	}

}
