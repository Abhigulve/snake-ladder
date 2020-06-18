package strategy;

import org.junit.Assert;
import org.junit.Test;
import strategy.CrookedDice;

public class CrookedTest {

    @Test
    public void testCrookedScore() {
        int score = new CrookedDice().rollDice();
        Assert.assertEquals(0, score % 2);
    }
}
