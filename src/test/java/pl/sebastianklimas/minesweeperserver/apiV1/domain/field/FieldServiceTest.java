package pl.sebastianklimas.minesweeperserver.apiV1.domain.field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldServiceTest {

    @Test
    public void test_getAssignedPosition() {
        FieldService fs = new FieldService();

        assertEquals(Field.PositionIn2dMatrix.TOP_LEFT, fs.getAssignedPosition(0, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.TOP_RIGHT, fs.getAssignedPosition(2, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.BOTTOM_LEFT, fs.getAssignedPosition(6, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.BOTTOM_RIGHT, fs.getAssignedPosition(8, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.MIDDLE_LEFT, fs.getAssignedPosition(3, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.MIDDLE_RIGHT, fs.getAssignedPosition(5, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.TOP_MIDDLE, fs.getAssignedPosition(1, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.BOTTOM_MIDDLE, fs.getAssignedPosition(7, 3, 9));
        assertEquals(Field.PositionIn2dMatrix.MIDDLE_MIDDLE, fs.getAssignedPosition(4, 3, 9));
    }
}