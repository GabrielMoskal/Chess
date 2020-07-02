package mycompany.app.board;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

public class PositionConverterTest {

    private PositionConverter converter;

    @Before
    public void setUp() {
        converter = new PositionConverter();
    }

    @Test
    public void convertsPositionProperly() {
        Point expected = new Point(0, 0);
        assertConvertsPositionProperly(expected, 'a', 1);
    }

    private void assertConvertsPositionProperly(Point expected, char xPosition, int yPosition) {
        Point result = converter.convert(xPosition, yPosition);
        assertEquals(expected, result);
    }

    @Test
    public void convertsOtherPositionProperly() {
        Point expected = new Point(2, 3);
        assertConvertsPositionProperly(expected, 'c', 4);
    }

    @Test(expected = InvalidPositionException.class)
    public void convertingXOutOfRangeThrowsException() {
        convertX('i');
    }

    private void convertX(char xPosition) {
        converter.convert(xPosition, 3);
    }

    @Test(expected = InvalidPositionException.class)
    public void convertingInvalidXCharacterThrowsException() {
        convertX('-');
    }

    @Test(expected = InvalidPositionException.class)
    public void convertingYAboveRangeThrowsException() {
        convertY(9);
    }

    private void convertY(int yPosition) {
        converter.convert('a', yPosition);
    }

    @Test(expected = InvalidPositionException.class)
    public void convertingYUnderRangeThrowsException() {
        convertY(0);
    }
}
