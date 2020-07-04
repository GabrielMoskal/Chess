package mycompany.app.pieces;

import mycompany.app.utility.Point;
import mycompany.app.pieces.PieceHelper.MoveDirection;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {

    private final PieceHelper helper;

    public Bishop(char x, int y, int boardSize) {
        super(x, y, boardSize);
        this.helper = new PieceHelper(this.getPosition(), this.getValidator());
    }

    public List<Point> findPossibleMoves() {
        List<Point> points = new LinkedList<>();

        points.addAll(helper.findMovesByFactor(MoveDirection.UpRight));
        points.addAll(helper.findMovesByFactor(MoveDirection.UpLeft));
        points.addAll(helper.findMovesByFactor(MoveDirection.DownLeft));
        points.addAll(helper.findMovesByFactor(MoveDirection.DownRight));

        return points;
    }
}
