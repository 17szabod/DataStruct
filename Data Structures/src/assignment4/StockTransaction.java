package assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import support.*;

public class StockTransaction {
	
	private DList<Stock> fullStocksList;
	
	public StockTransaction() throws FileNotFoundException {
		Scanner stock = new Scanner(new FileReader("stocks.txt"));
		Scanner transaction = new Scanner(new FileReader("transactions.txt"));
		DList<String> transactions = new DList<String>();
		DList<String> stocks = new DList<String>();
		while(stock.hasNext()) {
			stocks.addToFront(stock.nextLine());
		}
		while(transaction.hasNext()) {
			transactions.addToFront(transaction.nextLine());
		}
		stock.close();
		transaction.close();
		String tempChar = "";
		String totalString = "";
		DLLNode<String> temp = transactions.getHeader();
		DList<String> tempList = new DList<String>();
		while(temp != null) {
			String info = temp.getInfo();
			for(int x = 0; x < info.length(); x++) {
				tempChar = info.substring(x, x + 1);
				if (tempChar.equals(";") || x + 1 == info.length()) {
					if(x + 1 == info.length()) totalString += tempChar;
					tempList.addToLast(totalString);
					totalString = "";
				}
				else {
					totalString += tempChar;
				}
			}
			DLLNode<String> start = tempList.getHeader();
			fullStocksList.addToLast(new Stock(start.getInfo(), start.getLink().getInfo(), start.getLink().getLink().getInfo(), start.getLink().getLink().getLink().getInfo()));
			tempList = new DList<String>();
			temp = (DLLNode<String>) temp.getLink();
		}
	}
	
	public String stockCalc(String company) {
		String compInfo = (String) transactions.search(company).getInfo();
	}

}
