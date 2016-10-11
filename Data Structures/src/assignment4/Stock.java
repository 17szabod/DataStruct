package assignment4;

public class Stock {
	private String name;
	private String fullName;
	private boolean buy; // sell = false, buy = true
	private int quantity;
	private int value;
	
	public Stock(String myName, String myBuy, String myQuantity, String myValue, String myFullName) {
		name = myName;
		if(myBuy.equals("buy")) buy = true;
		else buy = false;
		quantity = Integer.parseInt(myQuantity);
		value = Integer.parseInt(myValue.substring(1));
		fullName = myFullName;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public boolean getBuy() {
		return buy;
	}
	
	public int getQuantity() {
		return quantity;
	}

}
