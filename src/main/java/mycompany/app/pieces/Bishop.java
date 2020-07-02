package mycompany.app.pieces;

import mycompany.app.board.PositionConverter;
import mycompany.app.utility.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop {

    private Point position;
    private final PositionConverter converter;

    public Bishop() {
        this.converter = new PositionConverter();
    }

    public Bishop(char x, int y) {
        this();
        this.position = converter.convert(x, y);
    }

    public List<Point> findPossibleMoves() {

        return new ArrayList<>(Arrays.asList(
                new Point(1, 1),
                new Point(0, 2),
                new Point(3, 1),
                new Point(4, 2),
                new Point(5, 3),
                new Point(6, 4),
                new Point(7, 5)
        ));
    }

}
