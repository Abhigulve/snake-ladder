package strategy;

import java.util.Random;

public class NormalDice implements DiceStrategy {
    @Override
    public int rollDice() {
        Random random = new Random();
        return 1+random.nextInt(6);
    }
}
