package org.example.rheinschwumm.exceptions;

public class OpenDataBaselStadtApiException extends Exception {
    public OpenDataBaselStadtApiException(String message) {
        super(message);
    }

    public OpenDataBaselStadtApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
