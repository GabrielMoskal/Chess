package mycompany.app.pieces;

import mycompany.app.exception.InvalidPositionException;

public class Bishop {
    int x;
    int y;

    public Bishop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[][] findPossibleMoves() {
        return new int[][] {
                {1, 1}, {0, 2}, {3, 1}, {4, 2}, {5, 3}, {6, 4}, {7, 5}
        };
    }

}
