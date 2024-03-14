package pl.sebastianklimas.minesweeperserver.apiV1.domain.field;

public class Field {
    private int content;
    private int position;
    private PositionIn2dMatrix positionIn2dMatrix = PositionIn2dMatrix.UNKNOWN;

    public Field(int content) {
        this.content = content;
    }

    public Field(int content, int position, PositionIn2dMatrix positionIn2dMatrix) {
        this.content = content;
        this.position = position;
        this.positionIn2dMatrix = positionIn2dMatrix;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public PositionIn2dMatrix getPositionIn2dMatrix() {
        return positionIn2dMatrix;
    }

    public void setPositionIn2dMatrix(PositionIn2dMatrix positionIn2dMatrix) {
        this.positionIn2dMatrix = positionIn2dMatrix;
    }

    public void increaseContentBy1() {
        this.content++;
    }

    public boolean isMine() {
        return content == -1;
    }

    @Override
    public String toString() {
        return String.valueOf(content);
    }

    public enum PositionIn2dMatrix {UNKNOWN, TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT}
}
