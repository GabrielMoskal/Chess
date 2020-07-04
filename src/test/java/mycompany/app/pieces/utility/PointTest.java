package mycompany.app.pieces.utility;

import mycompany.app.utility.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PointTest {

    @Test
    public void letterConstructorGivesTheSameResultAsNumberConstructor() {
        Point point1 = new Point('a', 1);
        Point point2 = new Point(0, 0);

        assertEquals(point1, point2);
    }

    @Test
    public void differentConstructorArgsGiveDifferentResults() {
        Point point1 = new Point('b', 3);
        Point point2 = new Point(6, 8);

        assertNotEquals(point1, point2);
    }
}
