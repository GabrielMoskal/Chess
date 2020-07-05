package mycompany.app.pieces;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mycompany.app.utility.Point;
import mycompany.app.utility.PositionValidator;

import java.util.List;

@Getter
@EqualsAndHashCode
public abstract class Piece {

    private final Point position;

    public Piece(int x, int y) {
        this.position = new Point(x, y);
    }

    public Piece(char x, int y) {
        this.position = new Point(x, y);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    protected PieceHelper makePieceHelper(int size) {
        Point range = new Point(0, size - 1);
        PositionValidator validator = new PositionValidator(range);
        return new PieceHelper(position, validator);
    }

    abstract public List<Point> findPossibleMoves(int size);
}
