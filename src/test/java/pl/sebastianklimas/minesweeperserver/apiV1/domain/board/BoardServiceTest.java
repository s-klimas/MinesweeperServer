package pl.sebastianklimas.minesweeperserver.apiV1.domain.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.board.dto.BoardDto;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.Field;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.FieldService;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooLessMinesException;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooManyMinesException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BoardServiceTest {

    @Mock FieldService fs;

    @InjectMocks
    private BoardService bs;

    @BeforeEach
    public void init() {
        fs = mock(FieldService.class);
        bs = new BoardService(fs);
    }


    @Test
    public void test_generateBoard_should_throw_TooManyMinesException() {
        // given
        int length = 3;
        int height = 3;
        int mines = 10;

        // then
        assertThrows(TooManyMinesException.class, () -> bs.generateBoard(length, height, mines));
    }

    @Test
    public void test_generateBoard_should_throw_TooLessMinesException() {
        // given
        int length = 3;
        int height = 3;
        int mines = 0;

        // then
        assertThrows(TooLessMinesException.class, () -> bs.generateBoard(length, height, mines));
    }

    @Test
    public void test_generateBoard_should_return_board() throws Exception {
        // given
        int length = 3;
        int height = 3;
        int mines = 3;

        // when
        when(fs.getAssignedPosition(anyInt(), anyInt(), anyInt())).thenReturn(Field.PositionIn2dMatrix.UNKNOWN);

        Optional<BoardDto> result = Optional.of(bs.generateBoard(length, height, mines));

        // then
        assertThat(result).isPresent();
        verify(fs, times(height * length)).getAssignedPosition(anyInt(), anyInt(), anyInt());
    }
}