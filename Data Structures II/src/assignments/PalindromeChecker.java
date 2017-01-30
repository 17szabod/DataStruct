package assignments;

public class PalindromeChecker {

	public static boolean CheckPalindrome(String plndrm) {
		// Input: A String plndrm that is to be checked on whether it's a
		// palindrome
		// Output: True or false, depending on whether plndrm is a palindrome
		boolean isPal = true;
		int n = 0;
		while (n <= plndrm.length() / 2) {
			if (!plndrm.substring(n, n + 1).equalsIgnoreCase(
					plndrm.substring(plndrm.length() - n - 1, plndrm.length()
							- n))) {
				isPal = false;
				break;
			}
			n++;
		}
		return isPal;
	}

	public static void main(String args[]) {
		String key = "algorithms";
		System.out.println(key);
		System.out.println(PalindromeChecker.CheckPalindrome(key));
	}
}