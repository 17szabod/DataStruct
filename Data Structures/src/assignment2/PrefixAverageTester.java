package assignment2;

public class PrefixAverageTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 750000;
		double[] arr = new double[n];
		for (int x = 0; x < n; x++) {
			arr[x] = 20.0;
		}
		long start = System.currentTimeMillis();
		PrefixAverage.prefixAverage1(arr);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		PrefixAverage.prefixAverage2(arr);
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
