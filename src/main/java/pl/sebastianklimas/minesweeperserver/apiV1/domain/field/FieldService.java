package pl.sebastianklimas.minesweeperserver.apiV1.domain.field;

import org.springframework.stereotype.Service;

@Service
public class FieldService {
    public Field.PositionIn2dMatrix getAssignedPosition(int i, int length, int size) {
        if (i == 0) {
            return Field.PositionIn2dMatrix.TOP_LEFT;
        } else if (i == length - 1) {
            return Field.PositionIn2dMatrix.TOP_RIGHT;
        } else if (i == size - length) {
            return Field.PositionIn2dMatrix.BOTTOM_LEFT;
        } else if (i == size - 1) {
            return Field.PositionIn2dMatrix.BOTTOM_RIGHT;
        } else if (i % length == 0) {
            return Field.PositionIn2dMatrix.MIDDLE_LEFT;
        } else if (i % length == length - 1) {
            return Field.PositionIn2dMatrix.MIDDLE_RIGHT;
        } else if (i < length) {
            return Field.PositionIn2dMatrix.TOP_MIDDLE;
        } else if (i > size - length) {
            return Field.PositionIn2dMatrix.BOTTOM_MIDDLE;
        } else {
            return Field.PositionIn2dMatrix.MIDDLE_MIDDLE;
        }
    }
}
