package assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StocksTest {
	public static void main(String[] args) throws IOException {
		FileReader test = null;
		try {
			test = new FileReader(new File("stocks.txt").getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner ou = new Scanner(test);
		System.out.println(ou.toString());
		test.close();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a input stock quote for realized gain(or loss) for the stock : ");
		StockTransaction transacter = new StockTransaction();
		System.out.println(transacter.stockCalc(in.next()));
	}
}
