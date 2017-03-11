package assignments;


public class HeapSort {
	/**
	 * Sorts array arr in descending order
	 * @param arr  array to be sorted
	 * @return the heap array construction and the sorted list
	 */
	public static String sortHeap(int[] arr) {
		String result = "";
		int[] construct = new int[arr.length];
		for (int x = 0; x < arr.length; x++) {
			construct = constructAdd(construct, arr[x], x);
		}
		for (int i : construct) {
			result += i + " ";
		}
		result += "\n";
		for (int x = 0; x < construct.length; x++) {
			int currNode = construct[0];
			result += currNode + " ";
			int lastIndex = construct.length - x - 1;
			construct = swap(0, lastIndex, construct);
			construct = removeLast(construct, lastIndex);
		}
		return result;
	}
	/**
	 * Removes the root element of the heap array, replacing it with the last element and then heapifying it
	 * @param arr  the array from which to remove the element
	 * @param lastIndex  the index of the last element in the array
	 * @return the inputed array with root element removed in heap form
	 */
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
	/**
	 * Adds element i to position x in heapified array arr and then heapifies array
	 * @param arr  the heap array which should be added to
	 * @param i  the value being added
	 * @param x  the index to be added at
	 * @return  the heap adjusted array with new element
	 */
	private static int[] constructAdd(int[] arr, int i, int x) {
		arr[x] = i;
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
	/**
	 * Swaps elements at i and j in array arr
	 * @param i  the index of one of the elements
	 * @param j  the index of the other element
	 * @param arr  the array in which to swap
	 * @return  the array inputed with specified elements swapped
	 */
	private static int[] swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	public static void main(String[] args) {
		//int[] arr = {10, 9, 4, 3, 7, 1, 5, 2, 8, 6, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] arr = new int[10000];
		for (int x = 0; x < 10000; x++) {
			arr[x] = (int) (Math.random() * 100000);
		}
		System.out.println(sortHeap(arr));
	}

}
