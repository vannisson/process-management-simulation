public class WordProcess implements Runnable{
    QueueManagement queue;

    String value;
    
    Thread process;
    

    public WordProcess(String value, QueueManagement queue) {
        this.value = value;
        this.process = new Thread(this, value);
        this.queue = queue;
        this.start();
    }

    public void start(){
        this.process.start();
    }

    @Override
    public void run() {
        queue.moveToQueueManagement(this);

        long start = System.currentTimeMillis();

        System.out.println("Process " + value+ " started!");
        try {
            Thread.sleep(value.length()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Process " + value + " finish || Elapsed Time: " + elapsed/1000 +" secs");

        queue.removeFromProcessQueue(this);
    }
}
