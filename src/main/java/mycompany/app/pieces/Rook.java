package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;

import java.util.LinkedList;
import java.util.List;

public class Rook {

    private Point position;
    private final int boardSize;
    private final PositionConverter converter;

    public Rook(int boardSize) {
        this.boardSize = boardSize;
        this.converter = new PositionConverter(boardSize);
    }

    public Rook(char x, int y, int boardSize) {
        this(boardSize);
        this.position = converter.convert(x, y);
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

    private boolean isInRange(int num) {
        return (num >= 0) && (num < boardSize);
    }
}
