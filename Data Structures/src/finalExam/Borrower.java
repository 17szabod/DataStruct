package finalExam;

public class Borrower {
	private String cardID;
	private String name;
	
	public Borrower(String id, String nam) {
		cardID = id;
		name = nam;
	}
	
	public String getName() {
		return name;
	}
	
	public String getID() {
		return cardID;
	}

}
