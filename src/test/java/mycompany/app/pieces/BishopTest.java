package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BishopTest {

    private Bishop bishop;

    @Test
    public void movesOnEmptyBoard() {
        List<Point> expected = makePoints(new int[] {
                'b', 2,
                'a', 3,
                'd', 2,
                'e', 3,
                'f', 4,
                'g', 5,
                'h', 6
        });
        bishop = new Bishop('c', 1);

        List<Point> result = bishop.findPossibleMoves();
        assertListsContainEqualContent(expected, result);
    }

    private List<Point> makePoints(int[] points) {
        List<Point> pointList = new LinkedList<>();
        PositionConverter converter = new PositionConverter();
        for (int i = 0; i < points.length; i += 2) {
            Point point = converter.convert((char)points[i], points[i + 1]);
            pointList.add(point);
        }
        return pointList;
    }

    private void assertListsContainEqualContent(List<Point> expected, List<Point> result) {
        sort(expected);
        sort(result);
        assertEquals(expected, result);
    }

    private void sort(List<Point> pointList) {
        Comparator<Point> comparator = (Point a, Point b) ->
                a.getX() == b.getX() ? a.getY() - b.getY() : a.getX() - b.getX();

        pointList.sort(comparator);
    }

    @Test
    public void movesOnEmptyBoardDifferentLocation() {
        List<Point> expected = makePoints(new int[] {
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
        bishop = new Bishop('e', 3);
        List<Point> result = bishop.findPossibleMoves();
        assertListsContainEqualContent(expected, result);
    }
}
