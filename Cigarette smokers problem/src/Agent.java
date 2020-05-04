public class Agent extends Thread {

    private Ingredient ingredient;

    public Agent(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public void run() {
        for (; ; ) {
            int ingredient1 = ((int) (Math.random() * 10)); //first random number
            int ingredient2 = ((int) (Math.random() * 10)); //second random number

            if ((ingredient1 != ingredient2) && (ingredient1 > 0 && ingredient1 < 4) && (ingredient2 > 0 && ingredient2 < 4)) {
                ingredient.put(ingredient1, ingredient2);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}
