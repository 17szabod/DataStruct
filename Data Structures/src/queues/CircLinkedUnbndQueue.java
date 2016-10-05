package queues;
import support.LLNode;

public class CircLinkedUnbndQueue<T> implements UnboundedQueueInterface<T> {

  protected LLNode<T> rear;


  public CircLinkedUnbndQueue() {
	  rear = null;
  }

  public T dequeue() throws QueueUnderflowException {
	  if (isEmpty()) {
		  throw new QueueUnderflowException();
	  }
	  LLNode<T> temp = new LLNode<T>(rear.getLink().getInfo());
	  if (rear.getLink() == rear) {
		  rear = null;
		  return temp.getInfo();
	  }
	  rear.setLink(rear.getLink().getLink());
	  rear.getLink().setLink(null);
	  return temp.getInfo();
  }

  public void enqueue(T element) {
	  if (isEmpty()) {
		  rear = new LLNode<T>(element);
		  rear.setLink(rear);
	  }
	  LLNode<T> e = new LLNode<T>(element);
	  e.setLink(rear.getLink());
	  rear.setLink(e);
	  rear = e;
  }

  public boolean isEmpty() {
	  if (rear == null) {
		  return true; 
	  }
	  return false;
  }
  
  public void print() {
	  if (isEmpty()) {
		  throw new QueueUnderflowException("Queue is empty");
	  }
	  LLNode<T> temp = rear;
	  while(temp.getLink() != rear) {
		  System.out.println(temp.getInfo());
		  temp = temp.getLink();
	  }
  }
  

}
