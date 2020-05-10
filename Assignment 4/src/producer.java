import java.time.*;
import java.util.*;

public class producer extends Thread
{
  private static int max_size  = 3; // producer can store maximum three items in the queue.
  private final List<String> messages = new ArrayList<>();

  public void run(){
    try
    {
      while(true)
      {
        produce();
      }
    }
    catch(Exception ex)
    {

    }
  }
  public synchronized void produce() throws Exception
  {
    while(messages.size() == max_size)
    {
      System.out.println("queue limit is reached waiting for consumer");
      wait();
      System.out.println("producer get notification from consumer");
    }
    messages.add(LocalDateTime.now().toString());
    System.out.println("producer produced data");
    notify();
  }
  public synchronized String consume() throws Exception
  {
    notify();
    while(messages.isEmpty())
    {
      wait();
    }
    String data = messages.get(0);
    messages.remove(data);
    return data;
  }
}
