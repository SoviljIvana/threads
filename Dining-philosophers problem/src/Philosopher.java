public class Philosopher extends Thread {

    Table table;

    public Philosopher(String name, int leftFork, int rightFork, Table table) {
        this.table = table;
    }

}
