public class Consumer extends Thread {

    Buffer buffer;

    public Consumer(Buffer b) {
        buffer = b;
    }

    @Override
    public void run() {
        int index;
        for (index = 1; index <= 10; index++) {
            buffer.get();
        }
    }
}
