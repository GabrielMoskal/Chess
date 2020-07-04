package mycompany.app.pieces;

import mycompany.app.utility.Point;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PiecesTestUtil {

    public List<Point> makePoints(int[] points) {
        List<Point> pointList = new LinkedList<>();
        for (int i = 0; i < points.length; i += 2) {
            Point point = new Point((char)points[i], points[i + 1]);
            pointList.add(point);
        }
        return pointList;
    }

    public void assertListsContainEqualContent(List<Point> expected, List<Point> result) {
        sort(expected);
        sort(result);
        assertEquals(expected, result);
    }

    private void sort(List<Point> pointList) {
        Comparator<Point> comparator = (Point a, Point b) ->
                a.getX() == b.getX() ? a.getY() - b.getY() : a.getX() - b.getX();

        pointList.sort(comparator);
    }
}
