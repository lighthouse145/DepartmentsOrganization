package altarix.test.departments.model.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Set;

@ToString
@AllArgsConstructor
public enum Position {

    LEADER,
    WORKER;

    private static final Set<Position> positionSet;

    static {
        positionSet = EnumSet.allOf(Position.class);
    }

    public static Set<Position> getAllPosition() {
        return positionSet;
    }


}
