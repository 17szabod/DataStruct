package assignment4;

import java.util.Scanner;

public class StocksTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a input stock quote for realized gain(or loss) for the stock : ");
		StockTransaction transacter = new StockTransaction();
		System.out.println(transacter.stockCalc(in.next()));
	}
}