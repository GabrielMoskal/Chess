package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PieceHelperTest {

    PiecesTestUtil testUtil;
    Point position;
    PieceHelper helper;

    @Before
    public void setUp() {
        testUtil = new PiecesTestUtil();
    }

    @Test
    public void findsCorrectMovesDiagonally() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'b', 2,
                'c', 3,
                'd', 4
        });
        position = new Point('a', 1);
        helper = new PieceHelper(position, 4);
        List<Point> result = helper.findMovesByFactor(1, 1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesDiagonallyDecreasing() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'e', 4,
                'd', 3,
                'c', 2,
                'b', 1
        });
        position = new Point('f', 5);
        helper = new PieceHelper(position, 6);
        List<Point> result = helper.findMovesByFactor(-1, -1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test(expected = InvalidPositionException.class)
    public void xPositionValueHigherThanMaxIndexThrowsException() {
        new PieceHelper(new Point('c', 2), 2);
    }

    @Test(expected = InvalidPositionException.class)
    public void yPositionValueHigherThanMaxIndexThrowsException() {
        new PieceHelper(new Point('b', 3), 2);
    }

    @Test
    public void findsCorrectMovesUpwards() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'a', 2,
                'a', 3,
                'a', 4,
        });
        position = new Point('a', 1);
        helper = new PieceHelper(position, 4);
        List<Point> result = helper.findMovesByFactor(0, 1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesDownwards() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'c', 4,
                'c', 3,
                'c', 2,
                'c', 1
        });
        position = new Point('c', 5);
        helper = new PieceHelper(position, 5);
        List<Point> result = helper.findMovesByFactor(0, -1);
        testUtil.assertListsContainEqualContent(expected, result);
    }
}
