// BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 8
//
// Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------

package trees;

import queues.*;
import stacks.*;
import support.BSTNode;      

public class BinarySearchTree<T extends Comparable<T>> 
             implements BSTInterface<T>
{
  protected BSTNode<T> root;      // reference to the root of this BST

  boolean found;   // used by remove
  
  // for traversals
  protected LinkedUnbndQueue<T> inOrderQueue;    // queue of info
  protected LinkedUnbndQueue<T> preOrderQueue;   // queue of info
  protected LinkedUnbndQueue<T> postOrderQueue;  // queue of info

  public BinarySearchTree()
  // Creates an empty BST object.
  {
    root = null;
  }

  public boolean isEmpty()
  // Returns true if this BST is empty; otherwise, returns false.
  {
    return (root == null);
  }

  private int recSize(BSTNode<T> tree)
  // Returns the number of elements in tree.
  {
    if (tree == null)    
      return 0;
    else
      return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
  }

  public int size()
  // Returns the number of elements in this BST.
  {
    return recSize(root);
  }

  public int size2()
  // Returns the number of elements in this BST.
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      hold.push(root);
      while (!hold.isEmpty())
      {
        currNode = hold.top();
        hold.pop();
        count++;
        if (currNode.getLeft() != null)
          hold.push(currNode.getLeft());
        if (currNode.getRight() != null)
          hold.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T element, BSTNode<T> tree)
  // Returns true if tree contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
  {
    if (tree == null)
      return false;       // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recContains(element, tree.getLeft());   // Search left subtree
    else if (element.compareTo(tree.getInfo()) > 0)
      return recContains(element, tree.getRight());  // Search right subtree
    else
      return true;        // element is found
  }

  public boolean contains (T element)
  // Returns true if this BST contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
  {
    return recContains(element, root);
  }
  
  private T recGet(T element, BSTNode<T> tree)
  // Returns an element e from tree such that e.compareTo(element) == 0;
  // if no such element exists, returns null.
  {
    if (tree == null)
      return null;             // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recGet(element, tree.getLeft());          // get from left subtree
    else
    if (element.compareTo(tree.getInfo()) > 0)
      return recGet(element, tree.getRight());         // get from right subtree
    else
      return tree.getInfo();  // element is found
  }

  public T get(T element)
  // Returns an element e from this BST such that e.compareTo(element) == 0;
  // if no such element exists, returns null.
  {
    return recGet(element, root);
  }

  private BSTNode<T> recAdd(T element, BSTNode<T> tree)
  // Adds element to tree; tree retains its BST property.
  {
    if (tree == null)
      // Addition place found
      tree = new BSTNode<T>(element);
    else if (element.compareTo(tree.getInfo()) <= 0)
      tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
    else
      tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
    return tree;
  }

  public void add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    root = recAdd(element, root);
  }

  private T getPredecessor(BSTNode<T> tree)
  // Returns the information held in the rightmost node in tree
  {
    while (tree.getRight() != null)
      tree = tree.getRight();
    return tree.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> tree)
  // Removes the information at the node referenced by tree.
  // The user's data in the node referenced by tree is no
  // longer in the tree.  If tree is a leaf node or has only
  // a non-null child pointer, the node pointed to by tree is
  // removed; otherwise, the user's data is replaced by its
  // logical predecessor and the predecessor's node is removed.
  {
    T data;

    if (tree.getLeft() == null)
      return tree.getRight();
    else if (tree.getRight() == null) 
      return tree.getLeft();
    else
    {
      data = getPredecessor(tree.getLeft());
      tree.setInfo(data);
      tree.setLeft(recRemove(data, tree.getLeft()));  
      return tree;
    }
  }

  private BSTNode<T> recRemove(T element, BSTNode<T> tree)
  // Removes an element e from tree such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  {
    if (tree == null)
      found = false;
    else if (element.compareTo(tree.getInfo()) < 0)
      tree.setLeft(recRemove(element, tree.getLeft()));
    else if (element.compareTo(tree.getInfo()) > 0)
      tree.setRight(recRemove(element, tree.getRight()));
    else  
    {
      tree = removeNode(tree);
      found = true;
	 }
    return tree;
  }

  public boolean remove (T element)
  // Removes an element e from this BST such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  {
    root = recRemove(element, root);
    return found;
  }

  private void inOrder(BSTNode<T> tree)
  // Initializes inOrderQueue with tree elements in inOrder order.
  {
    if (tree != null)
    {
      inOrder(tree.getLeft());
      inOrderQueue.enqueue(tree.getInfo());
      inOrder(tree.getRight());
    }
  }

  private void preOrder(BSTNode<T> tree)
  // Initializes preOrderQueue with tree elements in preOrder order.
  {
    if (tree != null)
    {
      preOrderQueue.enqueue(tree.getInfo());
      preOrder(tree.getLeft());
      preOrder(tree.getRight());
    }
  }

  private void postOrder(BSTNode<T> tree)
  // Initializes postOrderQueue with tree elements in postOrder order.
  {
    if (tree != null)
    {
      postOrder(tree.getLeft());
      postOrder(tree.getRight());
      postOrderQueue.enqueue(tree.getInfo());
    }
  }

  public int reset(int orderType)
  // Initializes current position for an iteration through this BST
  // in orderType order. Returns current number of nodes in the BST.
  {
    int numNodes = size();

    if (orderType == INORDER)
    {
      inOrderQueue = new LinkedUnbndQueue<T>();
      inOrder(root);
    }
    else
    if (orderType == PREORDER)
    {
      preOrderQueue = new LinkedUnbndQueue<T>();
      preOrder(root);
    }
    if (orderType == POSTORDER)
    {
      postOrderQueue = new LinkedUnbndQueue<T>();
      postOrder(root);
    }
    return numNodes;
  }

  public T getNext (int orderType)
  // Preconditions: The BST is not empty
  //                The BST has been reset for orderType
  //                The BST has not been modified since the most recent reset
  //                The end of orderType iteration has not been reached
  //
  // Returns the element at the current position on this BST for orderType
  // and advances the value of the current position based on the orderType. 
  {
    if (orderType == INORDER)
      return inOrderQueue.dequeue();
    else
    if (orderType == PREORDER)
      return preOrderQueue.dequeue();
    else
    if (orderType == POSTORDER)
      return postOrderQueue.dequeue();
    else return null;
  }
  
  private BSTNode<T> recGetLeftest(BSTNode<T> tree) {
		if (tree.getLeft() != null)
			return recGetLeftest(tree.getLeft());
		return tree;
	}

	public T getLeftest() {
		return recGetLeftest(root).getInfo();
	}

	private BSTNode<T> recGetRightest(BSTNode<T> tree) {
		  if (tree.getRight() != null)
			  return recGetRightest(tree.getRight());
		  return tree;
	}

	public T getRightest() {
		  return recGetRightest(root).getInfo();
	}

	private void recPrintLeaves(BSTNode<T> tree) {
		if(tree.getLeft() == null && tree.getRight() == null) {
			System.out.println(tree.getInfo());
		}
		if (tree.getLeft() != null)
			recPrintLeaves(tree.getLeft());
		if (tree.getRight() != null)
			recPrintLeaves(tree.getRight());
	}

	public void printLeaves() {
		recPrintLeaves(root);
	}
	
	private int recCount(T element, BSTNode<T> tree) {
		if (tree == null) return 0;
		if (element.compareTo(tree.getInfo()) <= 0) {
			if (element.compareTo(tree.getInfo()) == 0)
				return recCount(element, tree.getLeft()) + 1;
			else
				return recCount(element, tree.getLeft());
		}
		else if (element.compareTo(tree.getInfo()) > 0) {
			if (element.compareTo(tree.getInfo()) == 0)
				return recCount(element, tree.getRight()) + 1;
			else
				return recCount(element, tree.getRight());
		}
		return -1;//we had an error
	}
	
	public int count(T element) {
		return recCount(element, root);
	}
	
	public int count2(T element) {
		postOrderQueue = new LinkedUnbndQueue<T>();
		postOrder(root);
		T temp = null;
		int count = 0;
		while (!postOrderQueue.isEmpty()) {
			temp = postOrderQueue.dequeue();
			if (temp.compareTo(element) == 0)
				count++;
		}
		return count;
	}
  
  public void printSideways(){
	  printSideways(root,"");
  }

  private void printSideways(BSTNode<T> tree, String indent) {
	if(tree != null) {
		printSideways(tree.getRight(),indent+"    ");
		System.out.println(indent+tree.getInfo());
		printSideways(tree.getLeft(),indent+"    ");
	}
  }
  
  private BSTNode<T> recGetMax(BSTNode<T> tree) {
	  if (tree.getRight() != null)
		  return recGetMax(tree.getRight());
	  return tree;
  }
  
  public T getMax() {
	  return recGetMax(root).getInfo();
  }
  
  private T recSecondLargest(BSTNode<T> tree, T currSecond, boolean goneLeft) {
	  if (tree.getRight() != null) {
		  return recSecondLargest(tree.getRight(), tree.getInfo(), goneLeft);
	  }
	  else if (tree.getLeft() != null && !goneLeft) {
		  return recSecondLargest(tree.getLeft(), tree.getLeft().getInfo(), true);
	  }
	  else if (tree.getLeft() != null && goneLeft) {
		  return tree.getInfo();
	  }
	  return currSecond;
  }
  
  public T secondLargest() {
	  return recSecondLargest(root, null, false);
  }
  
  private BSTNode<T> recRevAdd(T element, BSTNode<T> tree)
  // Adds element to tree; tree retains its BST property.
  {
    if (tree == null)
      // Addition place found
      tree = new BSTNode<T>(element);
    else if (element.compareTo(tree.getInfo()) <= 0)
      tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
    else
      tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
    return tree;
  }
  
  public void revAdd(T element) {
	  recRevAdd(element, root);
  }
  
  private void recReverse(BSTNode<T> tree) {
	  if (tree.getLeft() != null)
		  recReverse(tree.getLeft());
	  if (tree.getRight() != null)
		  recReverse(tree.getRight());
	  BSTNode<T> temp = tree.getRight();
	  tree.setRight(tree.getLeft());
	  tree.setLeft(temp);
  }
  
  public BinarySearchTree<T> reverse() {
	  BinarySearchTree<T> copy = copy();
	  copy.recReverse(copy.root);
	  return copy;
  }
  
  private BSTNode<T> recCopy(BSTNode<T> tree) {
	  BSTNode<T> newNode = new BSTNode<T>(tree.getInfo());
	  if (tree.getLeft() != null) {
		  newNode.setLeft(recCopy(tree.getLeft()));
	  }
	  if (tree.getRight() != null) {
		  newNode.setRight(recCopy(tree.getRight()));
	  }
	  return newNode;
  }
  
  public BinarySearchTree<T> copy() {
	  BinarySearchTree<T> copy = new BinarySearchTree<T>();
	  copy.root = recCopy(root);
	  return copy;
  }
  
  private void recPrintRights(BSTNode<T> tree) {
	  if (tree != null) {
		  System.out.print(tree.getInfo() + " ");
		  recPrintRights(tree.getRight());
	  }
  }
  
  private void recPrintLefts(BSTNode<T> tree) {
	  if (tree != null) {
		  System.out.print(tree.getInfo() + " ");
		  recPrintLefts(tree.getLeft());
	  }
  }
  
  private void recPrintPaths(BSTNode<T> tree, String toPrint) {
	  if (tree != null) {
		  toPrint += tree.getInfo() + " ";
		  if (tree.getLeft() == null && tree.getRight() == null) {
			  System.out.println(toPrint);
		  }
		  recPrintPaths(tree.getLeft(), toPrint);
		  recPrintPaths(tree.getRight(), toPrint);
	  }
  }
  
  public void printPaths() {
	  recPrintPaths(root, "");
	  
  }
  
  private int recHeight(BSTNode<T> tree) {
	  if (tree.getLeft() == null && tree.getRight() == null) {
		  return 1;
	  }
	  int leftH = 0;
	  int rightH = 0;
	  if (tree.getLeft() != null)
		  leftH = recHeight(tree.getLeft()) + 1;
	  if (tree.getRight() != null)
		  rightH = recHeight(tree.getRight()) + 1;
	  if (leftH >= rightH)
		  return leftH;
	  else
		  return rightH;
  }
  
  public int height() {
	  return recHeight(root);
  }
}