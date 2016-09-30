package payment;
/**
 * A class for CreditCardPayment derived from Payment.
 * @author Daniel Szabo
 *
 */
public class CreditCardPayment extends Payment {

	private String name, expiration, creditcard;
	
	/**
	 * Default constructor; initialize amount to zero and strings to blank.
	 */
	public CreditCardPayment() {
		super();
		name="";
		expiration="";
		creditcard="";
		
	}

	/**
	 * constructor; initialize variables to input values.
	 * @param amt New amount for the payment
	 * @param name Name on the credit card
	 * @param expiration Expiration date
	 * @param creditcard Credit card number
	 */
	public CreditCardPayment(double amt, String name, String expiration, String creditcard) {
		super(amt);
		this.name = name;
		this.expiration = expiration;
		this.creditcard = creditcard;
	}

	/**
	 * paymentDetails outputs the amount of the payment and credit card information
	 */
	public void paymentDetails() {
		String output = "The credit card payment amount is " + getPayment() + "\n" + "The name on the card is: " + name
				+ "\n" + "The expiration date is: " + expiration + "\n" + "The credit card number is: " +  creditcard;
		System.out.println(output);
	}

}
