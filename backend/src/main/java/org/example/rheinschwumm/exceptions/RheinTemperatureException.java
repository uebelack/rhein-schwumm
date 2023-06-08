package org.example.rheinschwumm.exceptions;

public class RheinTemperatureException extends Exception {
    public RheinTemperatureException(String message) {
        super(message);
    }

    public RheinTemperatureException(String message, Throwable cause) {
        super(message, cause);
    }
}
