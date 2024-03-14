package pl.sebastianklimas.minesweeperserver.apiV1.domain.board;

import org.springframework.stereotype.Service;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.board.dto.BoardDto;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.Field;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.FieldService;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooLessMinesException;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooManyMinesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BoardService {
    private final FieldService fieldService;

    public BoardService(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    public BoardDto generateBoard(int length, int height, int mines) throws Exception {
        if (mines < 1) {
            throw new TooLessMinesException("There has to be at least one mine on map");
        }
        if (length  * height <= mines) {
            throw new TooManyMinesException("Board is to small for that amount of mines");
        }

        Board newBoard = new Board(height, length);

        List<Field> fields = generateFields(length, height, mines);

        newBoard.setBoard(fields);

        return BoardDtoMapper.map(newBoard);
    }

    private List<Field> generateFields(int length, int height, int mines) {
        List<Field> fields = new ArrayList<>();
        int count = length * height;

        for (int i = 0; i < count; i++) {
            Field.PositionIn2dMatrix position2D = fieldService.getAssignedPosition(i, length, count);
            fields.add(new Field(0, i, position2D));
        }

        while (mines > 0) {
            Random r = new Random();
            int potential = r.nextInt(fields.size());
            if (!fields.get(potential).isMine()) {
                fields.get(potential).setContent(-1);
                mines--;
            }
        }

        fields
                .forEach(field -> calculateField(field, length, fields));

        return fields;
    }

    private void calculateField(Field field, int length, List<Field> fields) {
        if (field.isMine()) return;

        int i = field.getPosition();

        switch (field.getPositionIn2dMatrix()) {
            case TOP_LEFT -> {
                checkRight(fields, i);
                checkBottomRight(fields, length, i);
                checkBottom(fields, length, i);
            }
            case TOP_MIDDLE -> {
                checkLeft(fields, i);
                checkBottomLeft(fields, length, i);
                checkBottom(fields, length, i);
                checkBottomRight(fields, length, i);
                checkRight(fields, i);
            }
            case TOP_RIGHT -> {
                checkLeft(fields, i);
                checkBottomLeft(fields, length, i);
                checkBottom(fields, length, i);
            }
            case MIDDLE_LEFT -> {
                checkTop(fields, length, i);
                checkTopRight(fields, length, i);
                checkRight(fields, i);
                checkBottomRight(fields, length, i);
                checkBottom(fields, length, i);
            }
            case MIDDLE_MIDDLE -> {
                checkTopLeft(fields, length, i);
                checkTop(fields, length, i);
                checkTopRight(fields, length, i);
                checkLeft(fields, i);
                checkRight(fields, i);
                checkBottomLeft(fields, length, i);
                checkBottom(fields, length, i);
                checkBottomRight(fields, length, i);
            }
            case MIDDLE_RIGHT -> {
                checkTop(fields, length, i);
                checkTopLeft(fields, length, i);
                checkLeft(fields, i);
                checkBottomLeft(fields, length, i);
                checkBottom(fields, length, i);
            }
            case BOTTOM_LEFT -> {
                checkTop(fields, length, i);
                checkTopRight(fields, length, i);
                checkRight(fields, i);
            }
            case BOTTOM_MIDDLE -> {
                checkLeft(fields, i);
                checkTopLeft(fields, length, i);
                checkTop(fields, length, i);
                checkTopRight(fields, length, i);
                checkRight(fields, i);
            }
            case BOTTOM_RIGHT -> {
                checkLeft(fields, i);
                checkTopLeft(fields, length, i);
                checkTop(fields, length, i);
            }
            case UNKNOWN -> {
            }
        }
    }

    private void checkTopLeft(List<Field> fields, int length, int i) {
        if (fields.get(i - length - 1).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkTop(List<Field> fields, int length, int i) {
        if (fields.get(i - length).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkTopRight(List<Field> fields, int length, int i) {
        if (fields.get(i - length + 1).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkLeft(List<Field> fields, int i) {
        if (fields.get(i - 1).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkRight(List<Field> fields, int i) {
        if (fields.get(i + 1).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkBottomLeft(List<Field> fields, int length, int i) {
        if (fields.get(i - 1 + length).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkBottom(List<Field> fields, int length, int i) {
        if (fields.get(i + length).isMine()) fields.get(i).increaseContentBy1();
    }

    private void checkBottomRight(List<Field> fields, int length, int i) {
        if (fields.get(i + length + 1).isMine()) fields.get(i).increaseContentBy1();
    }
}
