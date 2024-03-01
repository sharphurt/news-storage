package ru.sharphurt.newsstorage.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class SilentBaseException extends RuntimeException {

    private final String message;

    public SilentBaseException(String message) {
        super(message);
        log.error(message);
        this.message = message;
    }
}