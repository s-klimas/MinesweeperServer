package pl.sebastianklimas.minesweeperserver.apiV1.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.board.BoardService;
import pl.sebastianklimas.minesweeperserver.apiV1.domain.board.dto.BoardDto;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooLessMinesException;
import pl.sebastianklimas.minesweeperserver.apiV1.exceptions.TooManyMinesException;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/apiV1/get-game-board")
    public ResponseEntity<BoardDto> getBoard(@RequestParam int length,
                                             @RequestParam int height,
                                             @RequestParam int mines) throws Exception {
        return ResponseEntity.ok(boardService.generateBoard(length, height, mines));
    }

    @ExceptionHandler(TooManyMinesException.class)
    public ResponseEntity<Object> handleTooManyMinesException(TooManyMinesException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooLessMinesException.class)
    public ResponseEntity<Object> handleTooLessMinesException(TooLessMinesException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
