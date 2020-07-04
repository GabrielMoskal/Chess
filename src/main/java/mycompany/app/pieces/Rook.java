package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class Rook {

    private Point position;
    private final int boardSize;

    public Rook(int boardSize) {
        this.boardSize = boardSize;
    }

    public Rook(char x, int y, int boardSize) {
        this(boardSize);
        this.position = new Point(x, y);
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

    private boolean isInRange(int num) {
        return (num >= 0) && (num < boardSize);
    }

    public List<Point> findPossibleMoves() {
        List<Point> points = new LinkedList<>();

        // move right
        addLine(points, 1, 0);
        // move down
        addLine(points, 0, -1);
        // move left
        addLine(points, -1, 0);
        // move up
        addLine(points, 0, 1);

        return points;
    }

    private void addLine(List<Point> pointList, int xFactor, int yFactor) {
        int x = position.getX() + xFactor;
        int y = position.getY() + yFactor;
        while (isInRange(x) && isInRange(y)) {
            pointList.add(new Point(x, y));
            x += xFactor;
            y += yFactor;
        }
    }
}
