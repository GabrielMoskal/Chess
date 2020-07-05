package mycompany.app.pieces;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import mycompany.app.utility.Point;
import mycompany.app.utility.PositionValidator;

import java.util.List;

@Getter
@EqualsAndHashCode
public abstract class Piece {
    private final int boardSize;
    private final Point position;
    @EqualsAndHashCode.Exclude private final PositionValidator validator;

    public Piece(char x, int y, int boardSize) {
        this.boardSize = boardSize;
        this.position = new Point(x, y);
        this.validator = new PositionValidator(new Point(0, boardSize - 1));
        validator.checkInRange(position);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    abstract public List<Point> findPossibleMoves();
}
