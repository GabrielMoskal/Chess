package mycompany.app.board;

import mycompany.app.exception.InvalidPositionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PositionConverterTest {

    private PositionConverter converter;

    @Before
    public void setUp() {
        converter = new PositionConverter();
    }

    @Test
    public void convertsPositionProperly() {
        int[] expected = new int[] {0, 0};
        assertConvertsPositionProperly(expected, 'a', 1);
    }

    private void assertConvertsPositionProperly(int[] expected, char xPosition, int yPosition) {
        int[] result = converter.convert(xPosition, yPosition);
        assertArrayEquals(expected, result);
    }

    @Test
    public void convertsOtherPositionProperly() {
        int[] expected = new int[] {2, 3};
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
