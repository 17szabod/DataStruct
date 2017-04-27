import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * Creates and decodes Huffman tree from given file input
 * @author daniel
 *
 */
public class HuffmanTree {
	private static PriorityQueue<HuffNode> queue;
	private static HuffNode root;
	
	public static void main(String[] args) {
		queue = new PriorityQueue<HuffNode>();
		Scanner scan = null;
		try {
			//Could only find file for me when I put in the full path, might work differently on a different computer so
			//path would probably have to be changed
			scan = new Scanner(new FileReader("//home//daniel//workspace//Data Structures II//src//testCase2.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Change the filepath");
			e.printStackTrace();
		}
		while (scan.hasNextLine()) {
			String symbol = scan.next();
			double freq = scan.nextDouble();
			queue.add(new HuffNode(symbol, freq));
		}
		System.out.println("The Huffman code for the given characters is:");
		decode();
	}
	/**
	 * Creates a Huffman tree and then prints the code
	 * Note printing is a side effect of this method
	 */
	private static void decode() {
		recAdd(queue.poll(), queue.poll());
		printLeaves(root, "");
	}
	/**
	 * A private method used for testing, thought I'd keep it in for kicks
	 * @param tree the root node of the tree to print
	 */
	private static void print(HuffNode tree) {
		System.out.println(tree.getValue() + " " + tree.getFreq());
		if (tree.getLeft() != null)
			print((HuffNode) tree.getLeft());
		if (tree.getRight() != null)
			print((HuffNode) tree.getRight());
	}
	/**
	 * Prints the codes of every leaf in a Huffman tree
	 * @param tree the root node of the tree to print the leaves of
	 * @param toPrint a String to hold the path to the root
	 */
	private static void printLeaves(HuffNode tree, String toPrint) {
		if (tree != null) {
			  if (tree.getLeft() == null && tree.getRight() == null) {
				  System.out.println(tree.getValue() + ": " + toPrint);
			  }
			  if (tree.getLeft() != null) {
				  printLeaves((HuffNode) tree.getLeft(), toPrint + "0");
			  }
			  if (tree.getRight() != null) {
				  printLeaves((HuffNode) tree.getRight(), toPrint + "1");
			  }
		  }
	}
	/**
	 * Recursively adds nodes from queue together to make a Huffman tree
	 * @param left the node with the smaller frequency
	 * @param right the node with the larger frequency
	 */
	private static void recAdd(HuffNode left, HuffNode right) {
		HuffNode parent = new HuffNode("NUM_VAL", right.getFreq() + left.getFreq());
		parent.setLeft(left);
		parent.setRight(right);
		if (queue.isEmpty()) {
			root = parent;
			return;
		}
		queue.add(parent);
		recAdd(queue.poll(), queue.poll());
	}
}
