package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class Bishop {

    private Point position;
    private int maxMoveLength;
    private final PositionConverter converter;

    public Bishop() {
        this.converter = new PositionConverter();
    }

    public Bishop(int maxMoveLength) {
        this();
        this.maxMoveLength = maxMoveLength;
    }

    public Bishop(char x, int y) {
        this(8);
        this.position = converter.convert(x, y);
    }

    public List<Point> findPossibleMoves() {
        List<Point> points = new LinkedList<>();

        addDiagonal(points, 1, 1);
        addDiagonal(points, -1, 1);
        addDiagonal(points, -1, -1);
        addDiagonal(points, 1, -1);

        return points;
    }

    private void addDiagonal(List<Point> pointList, int xFactor, int yFactor) {
        int x = position.getX();
        int y = position.getY();
        while (((x + xFactor) >= 0) && ((x + xFactor) < maxMoveLength) &&
                ((y + yFactor) >= 0) && ((y + yFactor) < maxMoveLength)) {
            x += xFactor;
            y += yFactor;
            pointList.add(new Point(x, y));
        }
    }
}
