import java.util.PriorityQueue;

public class HuffmanTree {
	private static PriorityQueue<HuffNode> queue;
	private static HuffNode root;
	public static void main(String[] args) {
		queue = new PriorityQueue<HuffNode>();
		queue.add(new HuffNode("A", .35));
		queue.add(new HuffNode("B", .1));
		queue.add(new HuffNode("C", .2));
		queue.add(new HuffNode("D", .2));
		queue.add(new HuffNode("_", .15));
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
