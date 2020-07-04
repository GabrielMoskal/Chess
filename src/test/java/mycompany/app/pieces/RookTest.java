package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RookTest {

    PiecesTestUtil testUtil;
    Rook rook;

    @Before
    public void setUp() {
        testUtil = new PiecesTestUtil();
    }

    @Test
    public void movesOnEmptyBoard() {
        List<Point> expected = testUtil.makePoints(new int[] {
                'a', 2,
                'a', 3,
                'a', 4,
                'a', 5,
                'a', 6,
                'a', 7,
                'a', 8,
                'b', 1,
                'c', 1,
                'd', 1,
                'e', 1,
                'f', 1,
                'g', 1,
                'h', 1
        });
        rook = new Rook('a', 1, 8);

        List<Point> result = rook.findPossibleMoves();
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void movesOnEmptyBoardDifferentLocation() {
        List<Point> expected = testUtil.makePoints(new int[] {
                'c', 5,
                'c', 6,
                'c', 7,
                'c', 8,
                'd', 4,
                'e', 4,
                'f', 4,
                'g', 4,
                'h', 4,
                'c', 3,
                'c', 2,
                'c', 1,
                'b', 4,
                'a', 4
        });
        rook = new Rook('c', 4, 8);

        List<Point> result = rook.findPossibleMoves();
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test(expected = InvalidPositionException.class)
    public void xPositionValueHigherThanMaxIndexThrowsException() {
        new Rook('c', 2, 2);
    }

    @Test(expected = InvalidPositionException.class)
    public void yPositionValueHigherThanMaxIndexThrowsException() {
        new Rook('b', 3, 2);
    }
}
