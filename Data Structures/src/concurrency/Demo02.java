package concurrency;
import threads.*;

public class Demo02
{
  public static void main(String[] args) throws InterruptedException
  {
    Counter  c = new Counter();
	 Runnable r = new Increase(c, 10000);
    Thread   t = new Thread(r);

    t.start();

    System.out.println("Count is:    " + c);
  }
}