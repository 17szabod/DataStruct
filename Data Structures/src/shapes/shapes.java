package shapes;

import java.util.Scanner;

public class shapes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int x = 0; x < n; x++) {
			int m = in.nextInt();
			arr[x] = m;
		}
		for (int x = 0; x < n; x++) {
			int m = arr[x];
			if (m <= 4) 
				System.out.println("Shape #" + (x + 1) + ": Johnny's favorite!");
			else
				System.out.println("Shape #" + (x + 1) + ": Johnny will not be pleased with this one.");
		}
	}

}
