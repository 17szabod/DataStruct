package payment;
/**
 * Superclass to store a payment amount and get a description
 * @author Daniel Szabo
 *
 */
public class Payment {

	private double amount;
	
	/**
	 * Default constructor; initialize amount to zero
	 */
	public Payment() {
		amount = 0;
	}

	/**
	 * constructor; initialize to amount parameter.
	 * @param amount New amount for the payment
	 */
	public Payment(double amount) {
		setPayment(amount);
	}

	/**
	 * returns the payment amount
	 * @return the amount of payment
	 */
	public double getPayment() {
		return amount;
	}

	/**
	 * initializes the amount to input value
	 * @param amount New amount for the payment
	 */
	public void setPayment(double amount) {
		this.amount = amount;
	}

	/**
	 * outputs the amount of the payment
	 */
	public void paymentDetails() {
		System.out.println("The payment amount is " + getPayment());
	}

	/**
	 * checks if two objects are equal based on their payment amount and class name
	 * @param otherObject The Payment object to be compared
	 * @return true if both objects have equal amounts and are from the same class, otherwise return false
	 */
	public boolean equals(Object otherObject) {
		if (this.getPayment() == ((Payment) otherObject).getPayment()
				&& otherObject.getClass().getName().equals(this.getClass().getName())) {
			return true;
		}
		return false;
	}

}
