package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class PieceHelper {

    private final Point position;
    private final int boardSize;

    public PieceHelper(Point position, int boardSize) {
        this.position = position;
        this.boardSize = boardSize;
        checkPositionInIndexRange();
    }

    private void checkPositionInIndexRange() {
        if (!isPositionValid()) {
            throw new InvalidPositionException("Position should be in range between 0 and " + (boardSize - 1));
        }
    }

    private boolean isPositionValid() {
        return isInRange(position.getX()) && isInRange(position.getY());
    }

    public List<Point> findMovesByFactor(int xFactor, int yFactor) {
        List<Point> points = new LinkedList<>();
        int x = position.getX() + xFactor;
        int y = position.getY() + yFactor;
        while (isInRange(x) && isInRange(y)) {
            points.add(new Point(x, y));
            x += xFactor;
            y += yFactor;
        }
        return points;
    }

    private boolean isInRange(int num) {
        return (num >= 0) && (num < boardSize);
    }
}
