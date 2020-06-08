package strategy;

import java.util.Random;

public class CrookedDice implements DiceStrategy {
    @Override
    public int rollDice() {
        Random random = new Random();
        return 2 + random.nextInt(3) * 2;
    }
}
