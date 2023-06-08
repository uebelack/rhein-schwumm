package org.example.rheinschwumm.configuration;

import org.example.rheinschwumm.exceptions.RheinTemperatureException;
import org.example.rheinschwumm.models.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(RheinTemperatureException.class)
    public ResponseEntity<ErrorResponse> customHandleNotFound(RheinTemperatureException e) {
        logger.error("Could not get Rhein temperature", e);
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_GATEWAY.value(), "Service ist zur Zeit nicht verfügbar"), HttpStatus.BAD_GATEWAY);
    }
}
