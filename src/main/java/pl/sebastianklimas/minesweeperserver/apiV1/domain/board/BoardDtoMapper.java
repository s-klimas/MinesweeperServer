package pl.sebastianklimas.minesweeperserver.apiV1.domain.board;

import pl.sebastianklimas.minesweeperserver.apiV1.domain.board.dto.BoardDto;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.FieldDtoMapper;

public class BoardDtoMapper {
    public static BoardDto map(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoard(board.getBoard().stream().map(FieldDtoMapper::map).toList());
        boardDto.setHeight(board.getHeight());
        boardDto.setLength(board.getLength());
        return boardDto;
    }
}
