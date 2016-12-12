package finalExam;

public class Book {
	private String bookID;
	private String name;
	private String author;
	
	public Book(String id, String nam, String writer) {
		bookID = id;
		name = nam;
		author = writer;
	}
	
	public String getName() {
		return name;
	}
	
	public String getID() {
		return bookID;
	}
	
	public String getAuthor() {
		return author;
	}

}
