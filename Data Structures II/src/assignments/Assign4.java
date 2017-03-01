package assignments;

import java.util.Arrays;

public class Assign4 {
	public static String tranConMode(int[] arr) {
		int[] copy = arr.clone();
		Arrays.sort(copy);
		int maxConsec = 0;
		int consec = 0;
		int maxValue = -1;
		for (int x = 1; x < arr.length; x++) {
			if (copy[x] == copy[x - 1]) {
				consec++;
			}
			else {
				consec = 0;
			}
			if (consec > maxConsec) {
				maxConsec = consec;
				maxValue = copy[x];
			}
		}
		return maxValue + " " + maxConsec;
	}
	
	public static String bruteForceMode(int[] arr) {
		int[] modes = new int[arr.length];
		for (int i : arr) {
			modes[i] = modes[i] + 1;
		}
		int max = -1;
		int maxIndex = -1;
		for (int j = 0; j < arr.length; j++) {
			if (modes[j] > max) {
				max = modes[j];
				maxIndex = j;
			}
		}
		return maxIndex + " " + (max - 1);
	}

	public static void main(String[] args) {
		int[] in = new int[1000];
		for (int x = 0; x < 1000; x++) {
			in[x] = (int) (Math.random() * 100);
			System.out.print(in[x] + " ");
		}
		long start = System.nanoTime();
		String mode1 = bruteForceMode(in);
		long end = System.nanoTime();
		System.out.println();
		System.out.println(mode1 + "   time: " + (end - start));
		start = System.nanoTime();
		String mode2 = tranConMode(in);
		end = System.nanoTime();
		System.out.print(mode2 + "   time: " + (end - start));
		
	}

}
