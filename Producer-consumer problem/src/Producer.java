public class Producer extends Thread {

    Buffer buffer;

    public Producer(Buffer b) {
        buffer = b;
    }

    @Override
    public void run() {
        int index;
        for (index = 1; index <= 10; index++) {
            buffer.put(index);
        }
    }
}
