package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BishopTest {

    private Bishop bishop;

    @Test
    public void movesOnEmptyBoard() {
        List<Point> expected = new ArrayList<>(Arrays.asList(
                makePointWithGivenPosition('b', 2),
                makePointWithGivenPosition('a', 3),
                makePointWithGivenPosition('d', 2),
                makePointWithGivenPosition('e', 3),
                makePointWithGivenPosition('f', 4),
                makePointWithGivenPosition('g', 5),
                makePointWithGivenPosition('h', 6)
        ));
        bishop = new Bishop('c', 1);
        List<Point> result = bishop.findPossibleMoves();
        assertEquals(expected, result);
    }

    private Point makePointWithGivenPosition(char x, int y) {
        PositionConverter converter = new PositionConverter();
        return converter.convert(x, y);
    }

    @Test
    public void movesOnEmptyBoardDifferentLocation() {
        List<Point> expected = new ArrayList<>(Arrays.asList(
                makePointWithGivenPosition('d', 2),
                makePointWithGivenPosition('c', 1),
                makePointWithGivenPosition('d', 4),
                makePointWithGivenPosition('c', 5),
                makePointWithGivenPosition('b', 6),
                makePointWithGivenPosition('a', 7),
                makePointWithGivenPosition('f', 2),
                makePointWithGivenPosition('g', 1),
                makePointWithGivenPosition('f', 4),
                makePointWithGivenPosition('g', 5),
                makePointWithGivenPosition('h', 6)
                ));
        bishop = new Bishop('e', 3);
        List<Point> result = bishop.findPossibleMoves();
        assertEquals(expected, result);
    }
}
