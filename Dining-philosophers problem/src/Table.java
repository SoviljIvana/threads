import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Table {

    public int[] chopStick = new int[5];
    Random isHungry = new Random();
    Semaphore semaphore = new Semaphore(2);

    /**
     * Five chopsticks with values(1,2,3,4 or 5)
     * Philosophers(Aristotle, Plato, Socrates, Protagoras and Hippies) use two chopsticks to eat spaghetti
     * Aristotle uses chopStick[0] and chopStick[4]
     * Plato uses chopStick[1] and chopStick[0]
     * Socrates uses chopStick[2] and chopStick[1]
     * Protagoras uses chopStick[3] and chopStick[2]
     * Hippies uses chopStick[4] and chopStick[3]
     * When philosopher eats, chopstick has value 0
     */
    public void addChopSticksOnTheTable() {
        chopStick[0] = 1;
        chopStick[1] = 2;
        chopStick[2] = 3;
        chopStick[3] = 4;
        chopStick[4] = 5;
    }

    /**
     * If isHungry(random- true or false) is true- philosopher is hungry(method eat), else philosopher is thinking)
     *
     * @param leftFork
     */
    public void thinkingOrEating(int leftFork) {
        while (true) {
            try {
                sleep(4000);
            } catch (Exception e) {
            }
            if (leftFork == 1) {
                if (isHungry.nextBoolean() == true) {
                    System.out.println("Aristotle is thinking...");
                } else {
                    eat(chopStick[0], chopStick[4]);
                }
            } else if (leftFork == 2) {
                if (isHungry.nextBoolean() == true) {
                    System.out.println("Plato is thinking...");
                } else {
                    eat(chopStick[1], chopStick[0]);
                }
            } else if (leftFork == 3) {
                if (isHungry.nextBoolean() == true) {
                    System.out.println("Socrates is thinking...");
                } else {
                    eat(chopStick[2], chopStick[1]);
                }
            } else if (leftFork == 4) {
                if (isHungry.nextBoolean() == true) {
                    System.out.println("Protagoras is thinking...");
                } else {
                    eat(chopStick[3], chopStick[2]);
                }
            } else if (leftFork == 5) {
                if (isHungry.nextBoolean() == true) {
                    System.out.println("Hippies is thinking...");
                } else {
                    eat(chopStick[4], chopStick[3]);
                }
            }
        }
    }

    /**
     * When philosopher is hungry and he has free chopsticks-> he eats
     * else-> philosopher can't eat, philosopher is thinking
     *
     * @param leftChopStick
     * @param rightChopStick
     */
    public void eat(int leftChopStick, int rightChopStick) {
        if (leftChopStick == 1) {
            System.out.println("Aristotle is hungry...");
        } else if (leftChopStick == 2) {
            System.out.println("Plato is hungry...");
        } else if (leftChopStick == 3) {
            System.out.println("Socrates is hungry...");
        } else if (leftChopStick == 4) {
            System.out.println("Protagoras is hungry...");
        } else if (leftChopStick == 5) {
            System.out.println("Hippies is hungry...");
        }
        if (leftChopStick != 0 && rightChopStick != 0) {
            try {
                semaphore.acquire();
            } catch (Exception e) {
            }
            if (leftChopStick == 1) {
                chopStick[0] = 0;
                chopStick[4] = 0;
                try {
                    System.out.println("Aristotle is eating...");
                    sleep(10000);
                } catch (Exception e) {
                }
                semaphore.release();
                chopStick[0] = 1;
                chopStick[4] = 5;
                System.out.println("Aristotle ate...");

            } else if (leftChopStick == 2) {
                chopStick[1] = 0;
                chopStick[0] = 0;
                try {
                    System.out.println("Plato is eating...");
                    sleep(10000);
                } catch (Exception e) {
                }
                semaphore.release();
                chopStick[1] = 2;
                chopStick[0] = 1;
                System.out.println("Plato ate...");
            } else if (leftChopStick == 3) {
                chopStick[2] = 0;
                chopStick[1] = 0;
                try {
                    System.out.println("Socrates is eating...");
                    sleep(10000);
                } catch (Exception e) {
                }
                semaphore.release();
                chopStick[2] = 3;
                chopStick[1] = 2;
                System.out.println("Socrates ate...");
            } else if (leftChopStick == 4) {
                chopStick[3] = 0;
                chopStick[2] = 0;
                try {
                    System.out.println("Protagoras is eating...");
                    sleep(10000);
                } catch (Exception e) {
                }
                semaphore.release();
                chopStick[3] = 4;
                chopStick[2] = 3;
                System.out.println("Protagoras ate...");
            } else if (leftChopStick == 5) {
                chopStick[4] = 0;
                chopStick[3] = 0;
                try {
                    System.out.println("Hippies is eating...");
                    sleep(10000);
                } catch (Exception e) {
                }
                semaphore.release();
                chopStick[4] = 5;
                chopStick[3] = 4;
                System.out.println("Hippies ate...");
            }
        } else {
            if (leftChopStick == 1) {
                System.out.println("Aristotle cant't eat");
                System.out.println("Aristotle is thinking...");

            } else if (leftChopStick == 2) {
                System.out.println("Plato cant't eat...");
                System.out.println("Plato is thinking...");
            } else if (leftChopStick == 3) {
                System.out.println("Socrates cant't eat...");
                System.out.println("Socrates thinking...");
            } else if (leftChopStick == 4) {
                System.out.println("Protagoras cant't eat...");
                System.out.println("Protagoras is thinking...");
            } else if (leftChopStick == 5) {
                System.out.println("Hippies cant't eat...");
                System.out.println("Hippies is thinking...");
            }
        }
    }
}