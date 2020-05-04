import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Ingredient {

    private LinkedList<Integer> table = new LinkedList<>();
    private Semaphore semaphorePaper = new Semaphore(0);
    private Semaphore semaphoreTobacco = new Semaphore(0);
    private Semaphore semaphoreMatches = new Semaphore(0);
    private Semaphore semaphoreAgent = new Semaphore(1);

    /**
     * This method add in LinkedList two ingredients (paper(1) and tobacco(2) OR paper(1) and matches(3) OR tobacco(2) and matches(3))
     *
     * @param ingredientFirst
     * @param ingredientSecond
     */
    public void put(int ingredientFirst, int ingredientSecond) {
        try {
            semaphoreAgent.acquire();
        } catch (Exception e) {
        }
        table.addFirst(ingredientFirst);
        table.addLast(ingredientSecond);
        System.out.println("!!! 1-> PAPER, 2-> TOBACCO, 3-> MATCHES...!!!\nAgent puts on the table: " + table.getFirst() + " and " + table.getLast());
        if ((table.getFirst() == 1 && table.getLast() == 2) || (table.getFirst() == 2 && table.getLast() == 1)) {
            semaphoreMatches.release();
        } else if ((table.getFirst() == 1 && table.getLast() == 3) || (table.getFirst() == 3 && table.getLast() == 1)) {
            semaphoreTobacco.release();
        } else {
            semaphorePaper.release();
        }
    }

    /**
     * This method add third ingredient(paper, tobacco or matches)
     */
    public void get() {
        if ((table.getFirst() == 1 && table.getLast() == 2) || (table.getFirst() == 2 && table.getLast() == 1)) {
            try {
                semaphoreMatches.acquire();
            } catch (Exception e) {
            }
            table.add(1, 3);
            System.out.println("Smoker MACTHES got: " + table.getFirst() + " and " + table.getLast());
            matchesCigaretteSmokerIsSmoking();
        } else if ((table.getFirst() == 1 && table.getLast() == 3) || (table.getFirst() == 3 && table.getLast() == 1)) {
            try {
                semaphoreTobacco.acquire();
            } catch (Exception e) {
            }
            table.add(1, 2);
            System.out.println("Smoker TOBACCO got: " + table.getFirst() + " and " + table.getLast());
            tobaccoCigaretteSmokerIsSmoking();
        } else {
            try {
                semaphorePaper.acquire();
            } catch (Exception e) {
            }
            table.add(1, 1);
            System.out.println("Smoker PAPER got: " + table.getFirst() + " and " + table.getLast());
            paperCigaretteSmokerIsSmoking();
        }
        semaphoreAgent.release();
    }

    public void paperCigaretteSmokerIsSmoking() {
        System.out.println("PAPER cigarette smoker is smoking...");
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
        }
    }

    public void tobaccoCigaretteSmokerIsSmoking() {
        System.out.println("TOBACCO cigarette smoker is smoking...");
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
        }
    }

    public void matchesCigaretteSmokerIsSmoking() {
        System.out.println("MATCHES cigarette smoker is smoking...");
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
        }
    }
}