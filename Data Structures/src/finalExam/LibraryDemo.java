package finalExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LibraryDemo {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Borrower> borrowers = new HashMap<String, Borrower>();
		Scanner scanBor = new Scanner(new File("borrowers.txt"));
		System.out.print("--reading borrowers.txt,");
		scanBor.nextLine();
		while (scanBor.hasNextLine()) {
			String temp = scanBor.nextLine();
			String[] lineData = temp.split(",");
			Borrower dude = new Borrower(lineData[0], lineData[1]);
			borrowers.put(lineData[0], dude);
		}
		HashMap<String, Book> books = new HashMap<String, Book>();
		Scanner scanBook = new Scanner(new File("books.txt"));
		System.out.print(" books.txt,");
		scanBook.nextLine();
		while (scanBook.hasNextLine()) {
			String temp = scanBook.nextLine();
			String[] lineData = temp.split(",");
			Book book = new Book(lineData[0], lineData[1], lineData[2]);
			books.put(lineData[0], book);
		}
		ArrayList<BookLoan> loans = new ArrayList<BookLoan>();
		Scanner scanLoan = new Scanner(new File("book-loan.txt"));
		System.out.println(" and book-loan.txt");
		scanLoan.nextLine();
		while (scanLoan.hasNextLine()) {
			String temp = scanLoan.nextLine();
			String[] lineData = temp.split(",");
			BookLoan loan = new BookLoan(lineData[0], lineData[1], lineData[2], lineData[3]);
			loans.add(loan);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter borrower card number: ");
		String cardID = input.next();
		Set<String> IDs = borrowers.keySet();
		if (!IDs.contains(cardID)) {
			System.out.println("I'm sorry, this user is not in our database");
		}
		else {
			System.out.println("Books borrowed by " + cardID + "(" + borrowers.get(cardID).getName() + ") are as follows:");
			boolean found = false;
			for (BookLoan e : loans) {
				if (e.getCardID().equals(cardID)) {
					found = true;
					String bookID = e.getBookID();
					System.out.println(books.get(bookID).getName() + ", due date: " + e.getDateIn());
				}
			}
			if (!found) {
				System.out.println(borrowers.get(cardID).getName() + " has yet to check out any books");
			}
		}
	}

}
