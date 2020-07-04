package mycompany.app.utility;

import mycompany.app.exception.InvalidPositionException;

public class PositionValidator {

    private final Point range;

    public PositionValidator(Point range) {
        this.range = range;
    }

    public void checkInRange(Point position) {
        if (!isPositionValid(position)) {
            throw new InvalidPositionException("Position should be in range between 0 and " + range.getY());
        }
    }

    private boolean isPositionValid(Point position) {
        return isInRange(position.getX()) && isInRange(position.getY());
    }

    public boolean isInRange(int num) {
        return (num >= range.getX()) && (num <= range.getY());
    }
}
