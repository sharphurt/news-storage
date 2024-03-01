package ru.sharphurt.newsstorage.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sharphurt.newsstorage.dto.api.ControllerErrorResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class, EmptyDatabaseException.class})
    public ControllerErrorResponse notFoundException(SilentBaseException e) {
        return ControllerErrorResponse.of(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SilentBaseException.class)
    public ControllerErrorResponse internalServerErrorHandler(SilentBaseException e) {
        return ControllerErrorResponse.of(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ControllerErrorResponse unknownException(RuntimeException e) {
        return ControllerErrorResponse.of(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}