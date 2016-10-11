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
		// Get the key for stock names
		/*DLLNode<String> tempStock = stocks.getHeader();
		while(tempStock != null) {
			String info = tempStock.getInfo();
			stockNameKey.addToFront(new Stock(info.substring(0, info.indexOf(";")), info.substring(info.indexOf(";") + 1)));
			tempStock = (DLLNode<String>) tempStock.getLink();
		}*/
		// Get the full list of stocks
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
			Stock thisStock = new Stock(start.getInfo(), start.getLink().getInfo(), start.getLink().getLink().getInfo(), start.getLink().getLink().getLink().getInfo(), stocks.search(start.getInfo().getInfo().substring(start.getInfo().indexOf(";") + 1)));
			fullStocksList.addToLast(thisStock);
			tempList = new DList<String>();
			temp = (DLLNode<String>) temp.getLink();
		}
	}

	public String stockCalc(String company) {
		String compInfo = (String) fullStocksList.search(company).getInfo();
	}

}
