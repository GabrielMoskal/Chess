package mycompany.app.pieces;

import mycompany.app.utility.Point;
import mycompany.app.pieces.PieceHelper.MoveDirection;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {

    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(char x, int y) {
        super(x, y);
    }

    @Override
    public List<Point> findPossibleMoves(int size) {
        List<Point> points = new LinkedList<>();
        PieceHelper helper = makePieceHelper(size);

        points.addAll(helper.findMovesByFactor(MoveDirection.Right));
        points.addAll(helper.findMovesByFactor(MoveDirection.Down));
        points.addAll(helper.findMovesByFactor(MoveDirection.Left));
        points.addAll(helper.findMovesByFactor(MoveDirection.Up));

        return points;
    }
}
