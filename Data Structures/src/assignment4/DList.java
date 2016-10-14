package assignment4;
/**
 * 
 */

import support.*;

/**
 * @author Praveen Madiraju
 *
 */
public class DList<T> {
	
  protected DLLNode<T> header;   
  protected DLLNode<T> trailer;

  protected int size;
    
/**
 * 
 */
public DList() {
	header = null;
	trailer = null;
	size = 0;

}

/**
 * @return the header
 */
public DLLNode<T> getHeader() {
	return header;
}

/**
 * @return the trailer
 */
public DLLNode<T> getTrailer() {
	return trailer;
}


/**
 * @return the size
 */
public int getSize() {
	return size;
}

// add element to the front of the list
public void addToFront(T elem) {
	DLLNode<T> newNode = new DLLNode<T>(elem);
	
	if (header == null) {
		header = newNode;
	}
	if (trailer == null)
		trailer = newNode;
	else {
		newNode.setLink(header);
		header.setBack(newNode);
		header = newNode;
	}
	size++;

}

/**
 * add element to the end of the list
 * @param elem - the element to be added
 */
public void addToLast(T elem) {
	DLLNode<T> newNode = new DLLNode<T>(elem);
	newNode.setLink(null);
	
	if (trailer == null) {
		trailer = newNode;
		header = newNode;
	}
	else {
		trailer.setLink(newNode);
		newNode.setBack(trailer);
		trailer = newNode;		
	}
	
	size++;
}
/**
 * Removes specified element from the list
 * @param element - the element to be removed
 * @throws Exception - a generic exception to be thrown if the list is empty
 */
public void remove(T element) throws Exception {
	if(isEmpty()) throw new Exception("Remove attempted on empty list");
	if(trailer.getInfo() == element) removeLast();
	boolean found = false;
	DLLNode<T> temp = header;
	while(temp != null) {
		if (temp.getInfo().equals(element)) {
			temp.getBack().setLink(temp.getLink());
			((DLLNode<T>) temp.getLink()).setBack(temp.getBack());
			found = true;
			break;
		}
		temp = temp.getBack();
	}
	if (!found) throw new Exception("Could not find element");
}
/**
 * Removes the last element of the list
 * @throws Exception 
 */
public void removeLast() throws Exception {
	if (isEmpty()) throw new Exception("Remove attempted on empty list");
	DLLNode<T> temp = trailer;
	trailer = trailer.getBack();
	temp.setBack(null);
	trailer.setLink(null);
}
/**
 * Removes the first element of the list
 * @throws Exception 
 */
public void removeFirst() throws Exception {
	if (isEmpty()) throw new Exception("Thing is empty");
	header = (DLLNode<T>) header.getLink();
	header.setBack(null);
}
/**
 * Finds the first node that contain element
 * @precondition called on a DList of Strings
 * @param element - the element to be searched for
 * @return The node containing the element
 */
public DLLNode<String> search(String element) {
	DLLNode<String> temp = (DLLNode<String>) header;
	while(temp != null) {
		if (temp.getInfo().contains(element)) {
			return temp;
		}
		temp = (DLLNode<String>) temp.getLink();
	}
	return null;
}
/**
 * Checks if the list is empty
 * @return a boolean of whether the list is empty
 */
public boolean isEmpty()
{
    return header == null;
}
/**
 * prints the list
 */
public void print() {
	DLLNode<T> v = header;
	while (v != null) {
		System.out.println(v.getInfo());
		v = (DLLNode)v.getLink();
	}
		
}





}