package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import support.*;
/**
 * A class that calculates capital gain
 * @author Daniel Szabo
 *
 */
public class StockTransaction {

	private DList<DList<String>> shares;
	private DList<String> nameKey;
/**
 * Has a side effect, prints out if file reading was successful
 */
	public StockTransaction() {
		Scanner stock = null;
		Scanner transaction = null;
		try {
			stock = new Scanner(new FileReader(new File("stocks.txt").getAbsolutePath()));
		}
		catch(FileNotFoundException e) {
			throw new StockException("failure to read stocks.txt");
		}
		try {
			transaction = new Scanner(new FileReader(new File("transactions.txt").getAbsolutePath()));
		}
		catch(FileNotFoundException e) {
			throw new StockException("failure to read transactions.txt");			
		}
		// Files have been successfully read if this point is reached
		System.out.println("--successfully read stocks.txt and transactions.txt");
		shares = new DList<DList<String>>();
		// add stock abbreviations and make a key for abbreviation to company name
		while(stock.hasNext()) {
			String thisLine = stock.nextLine();
			String stockCode = thisLine.substring(0, thisLine.indexOf(";"));
			nameKey.addToLast(thisLine);
			DList<String> thisList = new DList<String>();
			// put the stock code at the beginning of the list to help identify it in the future
			thisList.addToFront(stockCode);
			shares.addToFront(thisList);
		}
		// Add +/- values to appropriate stockCodes
		while(transaction.hasNext()) {
			String thisLine = transaction.nextLine();
			String stockCode = thisLine.substring(0, thisLine.indexOf(";"));
			DLLNode<DList<String>> temp = shares.getHeader();
			while(temp != null) {
				// If stockCode is the header of the list
				if(temp.getInfo().getHeader().getInfo().equals(stockCode)) {
					String transact = thisLine.substring(thisLine.indexOf(";") + 1);
					boolean buy = false;
					if(transact.substring(0, transact.indexOf(";")).equals("buy")) {
						buy = true;
					}
					transact = transact.substring(transact.indexOf(";") + 1);
					int quantity = Integer.parseInt(transact.substring(0, transact.indexOf(";")));
					transact = transact.substring(transact.indexOf(";") + 1);
					String value = transact.substring(1);
					if(buy) {
						for(int x = 0; x < quantity; x++) {
							temp.getInfo().addToLast(value);
						}
					}
					else {
						for(int x = 0; x < quantity; x++) {
							temp.getInfo().addToLast("-" + value);
						}
					}
				}
				temp = (DLLNode<DList<String>>) temp.getLink();
			}
		}
		stock.close();
		transaction.close();
	}
/**
 * calculates the capital gain or loss
 * @param company
 * @return String including capital gain or loss
 */
	public String stockCalc(String company) {
		DLLNode<DList<String>> temp = shares.getHeader();
		DList<String> list = null;
		while(temp != null) {
			if(temp.getInfo().getHeader().equals(company)) {
				list = temp.getInfo();
				break;
			}
		}
		String stockKey = list.getHeader().getInfo();
		list.removeFirst();
		DList<Double> buys = new DList<Double>();
		DList<Double> sells = new DList<Double>();
		DLLNode<String> start = list.getHeader();
		while(start != null) {
			double thisValue = Double.parseDouble(start.getInfo());
			if(thisValue < 0) {
				sells.addToLast(thisValue);
			}
			if(thisValue > 0) {
				buys.addToLast(thisValue);
			}
			start = (DLLNode<String>) start.getLink();
		}
		double total = 0;
		DLLNode<Double> tempBuy = buys.getHeader();
		DLLNode<Double> tempSell = sells.getHeader();
		// goes through buys and sells in parallel, stops when sells run out
		while(tempSell != null) {
			double buy = tempBuy.getInfo();
			double sell = Math.abs(tempBuy.getInfo());
			double diff = sell - buy;
			total += diff;
			try {
				tempBuy = (DLLNode<Double>) tempBuy.getLink();
			}
			catch(Exception e) {
				throw new StockException("More stocks sold than bought");
			}
			tempSell = (DLLNode<Double>) tempSell.getLink();
		}
		// Find the appropriate name for the stockCode
		String name = nameKey.search(stockKey).getInfo().substring(nameKey.search(stockKey).getInfo().indexOf(";") + 1);
		if(total > 0) {
			return "Congratulations, your realized gain for " + name + " is : $" + total;
		}
		if(total < 0) {
			return "Sorry, your realized loss for " + name + " is : $" + total;
		}
		return "Sorry, no realized gain(or loss) reported for " + name;
		
	}

}
