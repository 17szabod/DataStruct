package assignment2;

public class PrefixAverageTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100000;
		double[] arr = new double[n];
		for (int x = 0; x < n; x++) {
			arr[x] = 20.0;
		}
		long start = System.nanoTime();
		PrefixAverage.prefixAverage1(arr);
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = System.nanoTime();
		PrefixAverage.prefixAverage2(arr);
		end = System.nanoTime();
		System.out.println(end - start);
	}

}