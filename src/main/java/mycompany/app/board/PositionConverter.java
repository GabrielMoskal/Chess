package mycompany.app.board;

import mycompany.app.exception.InvalidPositionException;
import mycompany.app.utility.Point;

public class PositionConverter {

    int lowest;
    int highest;

    public PositionConverter() {
        this.lowest = 0;
        this.highest = 7;
    }

    public Point convert(char xPosition, int yPosition) {
        int x = convertCharPositionToIntRange(xPosition);
        int y = convertIntPositionToIntRange(yPosition);

        checkPositionsInRange(x, y);

        return new Point(x, y);
    }

    private int convertCharPositionToIntRange(char position) {
        return position - 'a';
    }

    private int convertIntPositionToIntRange(int position) {
        return position - 1;
    }

    private void checkPositionsInRange(int x, int y) {
        checkPositionValidity(x);
        checkPositionValidity(y);
    }

    private void checkPositionValidity(int position) {
        if (isInValidRange(position)) {
            throw new InvalidPositionException("position should be in range between 0 and 7");
        }
    }

    private boolean isInValidRange(int position) {
        return (position > highest) || (position < lowest);
    }
}
