package mycompany.app.utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(char x, int y) {
        this.x = x - 'a';
        this.y = y - 1;
    }
}
