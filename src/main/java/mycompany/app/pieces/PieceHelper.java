package mycompany.app.pieces;

import lombok.Getter;
import mycompany.app.utility.Point;
import mycompany.app.utility.PositionValidator;

import java.util.LinkedList;
import java.util.List;

public class PieceHelper {

    @Getter
    public enum MoveDirection {
        Up(0, 1), Down(0, -1),
        Left(-1, 0), Right(1, 0),
        UpLeft(-1, 1), UpRight(1, 1),
        DownLeft(-1, -1), DownRight(1, -1);

        private final int xFactor;
        private final int yFactor;

        MoveDirection(int xFactor, int yFactor) {
            this.xFactor = xFactor;
            this.yFactor = yFactor;
        }
    }

    private final Point position;
    private final PositionValidator validator;

    public PieceHelper(Point position, PositionValidator validator) {
        this.position = position;
        this.validator = validator;
        validator.checkInRange(position);
    }

    public List<Point> findMovesByFactor(MoveDirection direction) {
        return findMovesByFactor(direction.getXFactor(), direction.getYFactor());
    }

    public List<Point> findMovesByFactor(int xFactor, int yFactor) {
        List<Point> points = new LinkedList<>();
        int x = position.getX() + xFactor;
        int y = position.getY() + yFactor;
        while (validator.isInRange(x) && validator.isInRange(y)) {
            points.add(new Point(x, y));
            x += xFactor;
            y += yFactor;
        }
        return points;
    }
}
