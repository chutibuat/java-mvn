package wlb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoyaltyTest {
    @Test
    public void receiveTotalPrice239_90ShouldGetNormalPoints23() {
        // arrange
        int expectedNormalPoints = 23;
        Royalty royalty = new Royalty();

        // action
        Point actualNormalPoints = royalty.calculate(239.90);

        // assert
        assertEquals(expectedNormalPoints, actualNormalPoints.getNormalPoints());
    }

    @Test
    public void receiveTotalPrice400_00ShouldGetNormalPoints40() {
        // arrange
        int expectedNormalPoints = 40;
        Royalty royalty = new Royalty();

        // action
        Point actualNormalPoints = royalty.calculate(400);

        // assert
        assertEquals(expectedNormalPoints, actualNormalPoints.getNormalPoints());
    }
}