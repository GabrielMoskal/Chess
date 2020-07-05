package mycompany.app.board;

import mycompany.app.pieces.Bishop;
import mycompany.app.pieces.Piece;
import mycompany.app.pieces.Rook;
import mycompany.app.utility.Point;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board(8);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void creatingBoardWithNegativeValueThrowsException() {
        board = new Board(-1);
    }

    @Test
    public void addAndFindPieceWorks() {
        Piece expected = new Rook('a', 1);
        board.add(expected);
        Piece result = board.find(new Point('a', 1));
        assertSameClassAndEquals(expected, result);
    }

    private void assertSameClassAndEquals(Piece expected, Piece result) {
        assertEquals(expected, result);
        assertEquals(expected.getClass(), result.getClass());
    }

    @Test
    public void addAndFindOtherPieceWorks() {
        Piece expected = new Bishop('b', 3);
        board.add(expected);
        Piece result = board.find(new Point('b', 3));
        assertSameClassAndEquals(expected, result);
    }

    @Test
    public void findNonExistingPieceReturnsNull() {
        assertNull(board.find(new Point('a', 1)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void xFindHigherThanBoardSize() {
        board.find(new Point(8, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void yFindHigherThanBoardSize() {
        board.find(new Point(0, 8));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void xFindNegative() {
        board.find(new Point(-1, 0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void yFindNegative() {
        board.find(new Point(0, -1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void xAddHigherThanBoardSize() {
        board.add(new Rook('i', 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void yAddHigherThanBoardSize() {
        board.add(new Rook('a', 9));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void xAddNegative() {
        board.add(new Rook(-1, 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void yAddNegative() {
        board.add(new Rook(0, -1));
    }


//    @Test
//    public void moveOfPieceChangeItsPosition() {
//        Piece pieceFrom = new Rook('a', 1, size);
//        board.add(pieceFrom);
//        Point from = new Point('a', 1);
//        Point to = new Point('a', 2);
//        board.move(from, to);
//        Piece empty = board.find(from);
//        assertNull(piece);
//        Piece pieceTo = board.find(to);
//        pieceTo.equals(pieceFrom);
//    }
}
