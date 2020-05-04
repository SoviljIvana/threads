import java.util.Random;

public class Main {

    private static final int MIN_VALUE = 2000;
    private static final int MAX_VALUE = 5000;

    public static void main(String args[]) {

        Random random = new Random();
        Table table = new Table();

        table.addChopSticksOnTheTable();

        Philosopher philosopher1 = new Philosopher("Aristotle", table.chopStick[0], table.chopStick[4], table) {
            @Override
            public void run() {
                int randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                    try {
                        sleep(randomNumber);
                    } catch (Exception e) {
                    }
                    table.thinkingOrEating(1);
                }

        };

        Philosopher philosopher2 = new Philosopher("Plato", table.chopStick[1], table.chopStick[0], table) {
            @Override
            public void run() {try {
                int randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                        sleep(randomNumber);
                    } catch (Exception e) {
                    }
                    table.thinkingOrEating(2);
                }
        };

        Philosopher philosopher3 = new Philosopher("Socrates", table.chopStick[2], table.chopStick[1], table) {
            @Override
            public void run() {
                int randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                try {
                        sleep(randomNumber);
                    } catch (Exception e) {
                    }
                    table.thinkingOrEating(3);
            }
        };

        Philosopher philosopher4 = new Philosopher("Protagoras", table.chopStick[3], table.chopStick[2], table) {
            @Override
            public void run() {
                int randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                try {
                    sleep(randomNumber);
                } catch (Exception e) {
                }
                table.thinkingOrEating(4);
            }
        };

        Philosopher philosopher5 = new Philosopher("Hippies", table.chopStick[4], table.chopStick[3], table) {
            @Override
            public void run() {
                int randomNumber = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                    try {
                        sleep(randomNumber);
                    } catch (Exception e) {
                    }
                    table.thinkingOrEating(5);
                }

        };

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }
}