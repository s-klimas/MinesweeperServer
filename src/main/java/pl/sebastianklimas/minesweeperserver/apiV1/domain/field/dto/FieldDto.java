package pl.sebastianklimas.minesweeperserver.apiV1.domain.field.dto;

import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.Field;

public class FieldDto {
    private int content;
    private Field.PositionIn2dMatrix positionIn2dMatrix = Field.PositionIn2dMatrix.UNKNOWN;

    public FieldDto() {
    }

    public FieldDto(int content, boolean isRevealed, Field.PositionIn2dMatrix positionIn2dMatrix) {
        this.content = content;
        this.positionIn2dMatrix = positionIn2dMatrix;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Field.PositionIn2dMatrix getPositionIn2dMatrix() {
        return positionIn2dMatrix;
    }

    public void setPositionIn2dMatrix(Field.PositionIn2dMatrix positionIn2dMatrix) {
        this.positionIn2dMatrix = positionIn2dMatrix;
    }

    public boolean isMine() {
        return content == -1;
    }
}
