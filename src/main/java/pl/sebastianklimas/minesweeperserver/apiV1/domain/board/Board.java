package pl.sebastianklimas.minesweeperserver.apiV1.domain.board;

import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.Field;

import java.util.List;

public class Board {
    private List<Field> board;
    private int height;
    private int length;

    public Board() {
    }

    public Board(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public Board(List<Field> board, int height, int length) {
        this.board = board;
        this.height = height;
        this.length = length;
    }

    public List<Field> getBoard() {
        return board;
    }

    public void setBoard(List<Field> board) {
        this.board = board;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
