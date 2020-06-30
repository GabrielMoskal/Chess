package mycompany.app.pieces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BishopTest {

    private Bishop bishop;

    @Before
    public void setUp() {
        bishop = new Bishop(2, 0);
    }

    @Test
    public void movesOnEmptyBoard() {
        int[][] expected = {
                {1, 1}, {0, 2}, {3, 1}, {4, 2}, {5, 3}, {6, 4}, {7, 5}
        };
        int[][] result = bishop.findPossibleMoves();
        assertArrayEquals(expected, result);
    }

}
