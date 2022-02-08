import java.util.ArrayList;

public class QueueManagement {
    
    ArrayList<WordProcess> queue;
    int size;

    public QueueManagement(Integer size) {
        queue = new ArrayList<WordProcess>();
        this.size = size;
    }

    public void moveToQueueManagement(WordProcess word) {
        if (queue.size() >= size) {
            synchronized (this) {
                try {
                    System.out.println("Process " + Thread.currentThread().getName() + " is waiting to join the queue");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        queue.add(word);
    }

    public void removeFromProcessQueue(WordProcess word) {
        synchronized (this){
            queue.remove(word);
            notify();
            System.out.println("Process " + Thread.currentThread().getName() + " was removed from the queue");
        }

    }
}
