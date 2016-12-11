package assignment6;

import java.util.Scanner;

public class StacksonStacks {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = 0;
		int[][] supArr = new int[n][10000];
		for (int y = 0; y < n; y++) {
			m = in.nextInt();
			int[] arr = new int[m];
			for (int x = 0; x < m; x++) {
				arr[x] = in.nextInt();
			}
			supArr[y] = arr;
		}
		int c = 0;
		int temp = 0;
		for (int y = 0; y < supArr.length; y++) {
			temp = supArr[y][0] % 2;
			for (int x = 1; x < supArr[y].length; x++) {
				int thisOne = supArr[y][x] % 2;
				if (temp - thisOne == 0) {
					c++;
				}
			}
			System.out.println("Row #" + y + ": Jerry needs to add a minimum of " + c + "coins");
		}
	}

}
