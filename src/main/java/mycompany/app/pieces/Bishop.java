package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class Bishop {

    private Point position;
    private final int boardSize;
    private final PositionConverter converter;

    public Bishop(int boardSize) {
        this.boardSize = boardSize;
        this.converter = new PositionConverter(boardSize);
    }

    public Bishop(char x, int y, int boardSize) {
        this(boardSize);
        this.position = converter.convert(x, y);
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

    private boolean isInRange(int num) {
        return (num >= 0) && (num < boardSize);
    }
}
