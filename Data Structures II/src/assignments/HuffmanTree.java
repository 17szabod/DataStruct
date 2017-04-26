import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanTree {
	private static PriorityQueue<HuffNode> queue;
	private static HuffNode root;
	public static void main(String[] args) {
		queue = new PriorityQueue<HuffNode>();
		Scanner scan = null;
		try {
			scan = new Scanner(new FileReader("H:\\New Attempt\\DataStruct\\Data Structures\\Data Structures II\\src\\assignments\\Huffman.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			String symbol = scan.next();
			double freq = scan.nextDouble();
			queue.add(new HuffNode(symbol, freq));
		}
		decode();
	}
	private static void decode() {
		recAdd(queue.poll(), queue.poll());
		//print(root);
		printLeaves(root, "");
	}
	
	private static void print(HuffNode tree) {
		System.out.println(tree.getValue() + " " + tree.getFreq());
		if (tree.getLeft() != null)
			print((HuffNode) tree.getLeft());
		if (tree.getRight() != null)
			print((HuffNode) tree.getRight());
	}
	
	private static void printLeaves(HuffNode tree, String toPrint) {
		if (tree != null) {
			  if (tree.getLeft() == null && tree.getRight() == null) {
				  System.out.println(toPrint + " " + tree.getValue());
			  }
			  if (tree.getLeft() != null) {
				  printLeaves((HuffNode) tree.getLeft(), toPrint + "0");
			  }
			  if (tree.getRight() != null) {
				  printLeaves((HuffNode) tree.getRight(), toPrint + "1");
			  }
		  }
	}
	
	private static boolean recAdd(HuffNode left, HuffNode right) {
		HuffNode parent = new HuffNode("NUM_VAL", right.getFreq() + left.getFreq());
		parent.setLeft(left);
		parent.setRight(right);
		if (queue.isEmpty()) {
			root = parent;
			if (root.getFreq() != 1.0) System.out.println("oh noes");
			return true;
		}
		queue.add(parent);
		return recAdd(queue.poll(), queue.poll());
	}
}
