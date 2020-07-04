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
        position = new Point('e', 4);
        helper = new PieceHelper(position, 8);
    }

    @Test
    public void findsCorrectMovesUpRight() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'f', 5,
                'g', 6,
                'h', 7
        });
        List<Point> result = helper.findMovesByFactor(1, 1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesUpLeft() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'd', 5,
                'c', 6,
                'b', 7,
                'a', 8
        });
        List<Point> result = helper.findMovesByFactor(-1, 1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesDownLeft() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'd', 3,
                'c', 2,
                'b', 1
        });
        List<Point> result = helper.findMovesByFactor(-1, -1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesDownRight() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'f', 3,
                'g', 2,
                'h', 1
        });
        List<Point> result = helper.findMovesByFactor(1, -1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesUp() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'e', 5,
                'e', 6,
                'e', 7,
                'e', 8
        });
        List<Point> result = helper.findMovesByFactor(0, 1);
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void findsCorrectMovesDown() {
        List<Point> expected = testUtil.makePoints(new int[]{
                'e', 3,
                'e', 2,
                'e', 1
        });
        List<Point> result = helper.findMovesByFactor(0, -1);
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
}
