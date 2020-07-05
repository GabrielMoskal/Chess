package mycompany.app.pieces;

import mycompany.app.utility.Point;
import mycompany.app.pieces.PieceHelper.MoveDirection;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(int x, int y) {
        super(x, y);
    }

    public Bishop(char x, int y) {
        super(x, y);
    }

    @Override
    public List<Point> findPossibleMoves(int size) {
        List<Point> points = new LinkedList<>();
        PieceHelper helper = makePieceHelper(size);

        points.addAll(helper.findMovesByFactor(MoveDirection.UpRight));
        points.addAll(helper.findMovesByFactor(MoveDirection.UpLeft));
        points.addAll(helper.findMovesByFactor(MoveDirection.DownLeft));
        points.addAll(helper.findMovesByFactor(MoveDirection.DownRight));

        return points;
    }
}
