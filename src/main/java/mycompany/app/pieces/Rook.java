package mycompany.app.pieces;

import mycompany.app.utility.Point;
import mycompany.app.pieces.PieceHelper.MoveDirection;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {

    private final PieceHelper helper;

    public Rook(char x, int y, int boardSize) {
        super(x, y, boardSize);
        this.helper = new PieceHelper(this.getPosition(), this.getValidator());
    }

    public List<Point> findPossibleMoves() {
        List<Point> points = new LinkedList<>();

        points.addAll(helper.findMovesByFactor(MoveDirection.Right));
        points.addAll(helper.findMovesByFactor(MoveDirection.Down));
        points.addAll(helper.findMovesByFactor(MoveDirection.Left));
        points.addAll(helper.findMovesByFactor(MoveDirection.Up));

        return points;
    }
}
