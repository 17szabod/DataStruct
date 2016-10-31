package trees;

//import support.BSTNode;

public class TestTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree= new BinarySearchTree<Integer>();
		/*tree.add(96);
		tree.add(24);
		tree.add(9);
		tree.add(58);
		tree.add(47);
		tree.add(93);
		tree.add(42);
		tree.add(24);
		tree.add(92);
		tree.add(66);*/
		tree.add(5);
		tree.add(10);
		tree.printSideways();
		/*
		
		int treeSize = tree.reset(BinarySearchTree.INORDER);
        System.out.println("The tree in Inorder is:");
        for (int count = 1; count <= treeSize; count++)
        {
          int element = (Integer) tree.getNext(BinarySearchTree.INORDER);
          System.out.println(element);
        }**/
		System.out.println(tree.secondLargest());

		
	}

}
