import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Buffer {

    static Semaphore semaphoreConsumer = new Semaphore(0);
    static Semaphore semaphoreProducer = new Semaphore(1);
    LinkedList<Integer> list = new LinkedList<>();

    /**
     * This method add elements in list
     *
     * @param data
     */
    void put(int data) {

        try {
            semaphoreProducer.acquire();
        } catch (InterruptedException e) {
        }
        list.add(data);
        System.out.println("Producer produce data:   " + data);
        semaphoreConsumer.release();
    }

    void get() {

        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("Consumer consume data: " + list.getLast());
        semaphoreProducer.release();

    }
}