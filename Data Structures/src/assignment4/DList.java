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

//add element to the end of the list
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

public void remove(T element) throws Exception {
	if(isEmpty()) throw new Exception("Thing is empty");
	if(trailer.getInfo() == element) removeLast();
	DLLNode<T> temp = header;
	while(temp != null) {
		if (temp.getInfo().equals(element)) {
			temp.getBack().setLink(temp.getLink());
			((DLLNode) temp.getLink()).setBack(temp.getBack());
		}
		temp = temp.getBack();
	}
}

public void removeLast() throws Exception {
	if (isEmpty()) throw new Exception("Thing is empty");
	DLLNode<T> temp = trailer;
	trailer = trailer.getBack();
	temp.setBack(null);
	trailer.setLink(null);
}

public DLLNode<String> search(String element) {
	DLLNode<String> temp = (DLLNode<String>) header;
	while(temp != null) {
		if (temp.getInfo().contains(element)) {
			return temp;
		}
	}
	return null;
}

public boolean isEmpty()
{
    return header == null;
}

public void print() {
	DLLNode<T> v = header;
	while (v != null) {
		System.out.println(v.getInfo());
		v = (DLLNode)v.getLink();
	}
		
}





}
