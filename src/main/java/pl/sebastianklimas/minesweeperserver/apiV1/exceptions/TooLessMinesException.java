package pl.sebastianklimas.minesweeperserver.apiV1.exceptions;

public class TooLessMinesException extends Exception {
    public TooLessMinesException(String message) {
        super(message);
    }
}
