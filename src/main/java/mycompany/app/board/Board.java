package mycompany.app.board;

import mycompany.app.pieces.Piece;
import mycompany.app.utility.Point;

public class Board {

    private final Piece[][] board;

    public Board(int size) {
        board = new Piece[size][size];
    }

    public void add(Piece piece) {
        int x = piece.getX();
        int y = piece.getY();
        board[x][y] = piece;
    }

    public Piece find(Point position) {
        int x = position.getX();
        int y = position.getY();
        return board[x][y];
    }
}
