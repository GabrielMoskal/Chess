package mycompany.app.utility;

import mycompany.app.exception.InvalidPositionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PositionValidatorTest {

    private PositionValidator validator;

    @Before
    public void setUp() {
        validator = new PositionValidator(new Point(0, 7));
    }

    @Test
    public void checksPositionInIndexRange() {
        Point position = new Point('a', 1);
        try {
            validator.checkInRange(position);
        } catch (InvalidPositionException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test(expected = InvalidPositionException.class)
    public void xPositionValueHigherThanMaxIndexThrowsException() {
        Point position = new Point('i', 1);

        validator.checkInRange(position);
    }

    @Test(expected = InvalidPositionException.class)
    public void yPositionValueHigherThanMaxIndexThrowsException() {
        Point position = new Point('a', 9);

        validator.checkInRange(position);
    }

    @Test
    public void numberIsInRange() {
        assertTrue(validator.isInRange(2));
    }

    @Test
    public void numberIsTooHigh() {
        assertFalse(validator.isInRange(8));
    }

    @Test
    public void numberIsTooLow() {
        assertFalse(validator.isInRange(-1));
    }
}
