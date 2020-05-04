public class Main {

    public static void main(String args[]) {

        Ingredient ingredient = new Ingredient();
        Agent agent = new Agent(ingredient);

        Smoker cigaretteSmoker1 = new Smoker(ingredient, "PAPER") {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        sleep(2000);
                    } catch (Exception e) {
                    }
                    ingredient.get();
                }
            }
        };

        Smoker cigaretteSmoker2 = new Smoker(ingredient, "TOBACCO") {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        sleep(2000);
                    } catch (Exception e) {
                    }
                    ingredient.get();
                }
            }
        };

        Smoker cigaretteSmoker3 = new Smoker(ingredient, "MATCHES") {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        sleep(2000);
                    } catch (Exception e) {
                    }
                    ingredient.get();
                }
            }
        };
        agent.start();
        cigaretteSmoker1.start();
        cigaretteSmoker2.start();
        cigaretteSmoker3.start();

    }
}
