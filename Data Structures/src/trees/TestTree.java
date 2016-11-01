package trees;

//import support.BSTNode;

public class TestTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree= new BinarySearchTree<Integer>();
		tree.add(1);
		tree.add(2);
		tree.printSideways();
		/*
		
		int treeSize = tree.reset(BinarySearchTree.INORDER);
        System.out.println("The tree in Inorder is:");
        for (int count = 1; count <= treeSize; count++)
        {
          int element = (Integer) tree.getNext(BinarySearchTree.INORDER);
          System.out.println(element);
        }**/
		System.out.println("Second Largest:");
		System.out.println(tree.secondLargest());
		System.out.println("Height:");
		System.out.println(tree.height());
		System.out.println("Paths:");
		tree.printPaths();
		System.out.println("Reversed:");
		tree.reverse().printSideways();

		
	}

}
