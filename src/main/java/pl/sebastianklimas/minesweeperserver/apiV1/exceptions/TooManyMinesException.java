package pl.sebastianklimas.minesweeperserver.apiV1.exceptions;

public class TooManyMinesException extends Exception {
    public TooManyMinesException(String message) {
        super(message);
    }
}
