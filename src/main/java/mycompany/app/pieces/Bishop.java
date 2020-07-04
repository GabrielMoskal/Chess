package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class Bishop {

    private Point position;
    private final int boardSize;

    public Bishop(int boardSize) {
        this.boardSize = boardSize;
    }

    public Bishop(char x, int y, int boardSize) {
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

        // move up-right
        addDiagonal(points, 1, 1);
        // move up-left
        addDiagonal(points, -1, 1);
        // move down-left
        addDiagonal(points, -1, -1);
        // move down-right
        addDiagonal(points, 1, -1);

        return points;
    }

    private void addDiagonal(List<Point> pointList, int xFactor, int yFactor) {
        int x = position.getX() + xFactor;
        int y = position.getY() + yFactor;
        while (isInRange(x) && isInRange(y)) {
            pointList.add(new Point(x, y));
            x += xFactor;
            y += yFactor;
        }
    }
}
