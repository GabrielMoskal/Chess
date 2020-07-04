package mycompany.app.pieces;

import mycompany.app.utility.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BishopTest {

    private Bishop bishop;
    private PiecesTestUtil testUtil;

    @Before
    public void setup() {
        testUtil = new PiecesTestUtil();
    }

    @Test
    public void movesOnEmptyBoard() {
        List<Point> expected = testUtil.makePoints(new int[] {
                'b', 2,
                'a', 3,
                'd', 2,
                'e', 3,
                'f', 4,
                'g', 5,
                'h', 6
        });
        bishop = new Bishop('c', 1, 8);

        List<Point> result = bishop.findPossibleMoves();
        testUtil.assertListsContainEqualContent(expected, result);
    }

    @Test
    public void movesOnEmptyBoardDifferentLocation() {
        List<Point> expected = testUtil.makePoints(new int[] {
                'd', 2,
                'c', 1,
                'd', 4,
                'c', 5,
                'b', 6,
                'a', 7,
                'f', 2,
                'g', 1,
                'f', 4,
                'g', 5,
                'h', 6
        });
        bishop = new Bishop('e', 3, 8);
        List<Point> result = bishop.findPossibleMoves();
        testUtil.assertListsContainEqualContent(expected, result);
    }
}
