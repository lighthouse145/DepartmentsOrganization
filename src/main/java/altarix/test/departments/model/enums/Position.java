package altarix.test.departments.model.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public enum Position {

    LEADER("руководитель"),
    WORKER("работник");

    private String position;
    private static final Set<Position> positionSet;

    static {
        positionSet = EnumSet.allOf(Position.class);
    }

    public String getPosition() {
        return this.position;
    }

    public static Set<Position> getAllPosition() {
        return positionSet;
    }

    public static String getByName(String namePosition) {
        String st = null;
        for (Position position : Position.getAllPosition()) {
            if (position.name().equals(namePosition)) {
                st = position.getPosition();
            }
        }
        return st;
    }

}
