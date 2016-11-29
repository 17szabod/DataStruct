package collections;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDupsClass {
	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("hi");
		test.add("my");
		test.add("hi");
		test.add("name");
		test.add("bob");
		System.out.println(removeDuplicates(test));
		System.out.println(test);
		System.out.println(remDup(test));
		System.out.println(test);
	}
	public static ArrayList<String> removeDuplicates(ArrayList<String> arr) {
		HashSet<String> set = new HashSet<String>();
		set.addAll(arr);
		ArrayList<String> ret = new ArrayList<String>();
		for (String e : set) {
			ret.add(e);
		}
		//Reverse ret
		ArrayList<String> rev = new ArrayList<String>();
		for (int x = 0; x < ret.size(); x++) {
			rev.add(ret.get(ret.size() - x - 1));
		}
		return rev;
	}
	
	public static ArrayList<String> remDup(ArrayList<String> arr) {
		ArrayList<String> copy = new ArrayList<String>();
		for (String e : arr) {
			copy.add(e);
		}
		for (int x = copy.size() - 1; x >= 0; x--) {
			for (int y = x + 1; y < copy.size(); y++) {
				if (copy.get(x).equals(copy.get(y))) {
					copy.remove(y);
				}
			}
		}
		return copy;
	}

}
