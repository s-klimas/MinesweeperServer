package pl.sebastianklimas.minesweeperserver.apiV1.domain.board.dto;

import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.dto.FieldDto;

import java.util.List;

public class BoardDto {
    private List<FieldDto> board;
    private int height;
    private int length;

    public BoardDto() {
    }

    public BoardDto(List<FieldDto> board, int height, int length) {
        this.board = board;
        this.height = height;
        this.length = length;
    }

    public List<FieldDto> getBoard() {
        return board;
    }

    public void setBoard(List<FieldDto> board) {
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
