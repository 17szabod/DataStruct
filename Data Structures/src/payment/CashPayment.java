package payment;
/**
 * A CashPayment class derive from Payment
 * @author Daniel Szabo
 *
 */
public class CashPayment extends Payment {
	
	/**
	 * Default constructor; initialize amount to zero
	 */
	public CashPayment() {
		super();
	}

	/**
	 * constructor; initialize amount to input value.
	 * @param amt New amount for payment
	 */
	public CashPayment(double amt) {
		super(amt);
	}
	
	/**
	 *  paymentDetails outputs the amount of the payment and indicates it is cash.
	 */
	public void paymentDetails() {
		System.out.println("The cash payment amount is " + getPayment());
	}

}
