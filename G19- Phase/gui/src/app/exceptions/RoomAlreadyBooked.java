package app.exceptions;

public class RoomAlreadyBooked extends RuntimeException {

    public RoomAlreadyBooked(String message) {
        super(message);
    }

    public RoomAlreadyBooked(String message, Throwable cause) {
        super(message, cause);
    }
}
