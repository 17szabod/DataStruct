package assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import support.*;

public class StockTransaction {
	
	private Scanner stock;
	private Scanner transaction;
	private DList<String> stocks;
	private DList<String> transactions;
	
	public StockTransaction() throws FileNotFoundException {
		stock = new Scanner(new FileReader("stocks.txt"));
		transaction = new Scanner(new FileReader("transactions.txt"));
		while(stock.hasNext()) {
			stocks.addToFront(stock.nextLine());
		}
		while(transaction.hasNext()) {
			transactions.addToFront(transaction.nextLine());
		}
		String tempString = "";
		String totalString = "";
		DLLNode temp = transactions.getHeader();
		while(temp != null) {
			String info = (String) temp.getInfo();
			for(int x = 0; x < info.length(); x++) {
				tempString = 
				if (info.equals(";")) {
					
				}
			}
		}
	}
	
	public String stockCalc(String company) {
		String compInfo = (String) transactions.search(company).getInfo();
		compInfo.replaceAll(";"," ");
	}

}
