package finalExam;

public class BookLoan {
	private String bookID;
	private String dateOut;
	private String dateIn;
	private String cardID;
	
	public BookLoan(String bid, String cid, String dOut, String dIn) {
		cardID = cid;
		bookID = bid;
		dateOut = dOut;
		dateIn = dIn;
	}
	
	public String getCardID() {
		return cardID;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public String getDateOut() {
		return dateOut;
	}
	
	public String getDateIn() {
		return dateIn;
	}

}
