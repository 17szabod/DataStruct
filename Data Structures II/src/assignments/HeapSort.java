package assignments;

public class HeapSort {

	public static void sortHeap(int[] arr) {
		int[] construct = new int[arr.length];
		for (int x = 0; x < arr.length; x++) {
			construct = constructAdd(construct, arr[x], x);
		}
		for (int i : construct) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int x = 0; x < construct.length; x++) {
			int currNode = construct[0];
			System.out.print(currNode + " ");
			int lastIndex = construct.length - x - 1;
			construct = swap(0, lastIndex, construct);
			construct = removeLast(construct, lastIndex);
		}
	}
	private static int[] removeLast(int[] arr, int lastIndex) {
		arr[lastIndex] = 0;
		int y = 0;
		boolean done = false;
		while(!done) {
			int nextY1 = y * 2 + 1;
			int nextY2 = y * 2 + 2;
			int nextY = 0;
			if (nextY2 <= lastIndex) {
				if (arr[nextY1] >= arr[nextY2])	nextY = nextY1;
				else	nextY = nextY2;
				if (arr[y] < arr[nextY]) {
					arr = swap(y, nextY, arr);
					y = nextY;
				}
				else  {
					done = true;
				}
			}
			else if (nextY1 <= lastIndex) {
				if (arr[y] < arr[nextY1]) {
					arr = swap(y, nextY1, arr);
					y = nextY1;
				}
				else  {
					done = true;
				}
			}
			else	done = true;
		}
		return arr;
		
	}
	private static int[] constructAdd(int[] arr, int i, int x) {
		boolean done = false;
		int nextX = x;
		while (!done) {
			nextX /= 2;
			if (i > arr[nextX])	arr = swap(x, nextX, arr);
			else done = true;
			if (nextX < 1)	done = true;
			x = nextX;
		}
		return arr;
	}
	private static int[] swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	public static void main(String[] args) {

	}

}
