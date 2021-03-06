import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Condition_example implements Runnable {

    public static ReentrantLock lock =new ReentrantLock();
    public static Condition  condition =lock.newCondition();

    public void run()
    {
        try
        {
            lock.lock();
            condition.await();
            System.out.println("Thread is  going on");
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception
    {
        Condition_example conditionExample =new Condition_example();
        Thread  t1 =new Thread(conditionExample);
        t1.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
