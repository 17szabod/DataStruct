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
	  LLNode<T> last = rear;
	  rear = new LLNode<T>(element);
	  rear.setLink(new LLNode<T>(element));
  }

  public boolean isEmpty() {
	  if (rear == null) {
		  return true; 
	  }
	  return false;
  }
  

}
