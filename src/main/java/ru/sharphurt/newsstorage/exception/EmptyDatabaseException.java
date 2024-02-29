package ru.sharphurt.newsstorage.exception;

import static ru.sharphurt.newsstorage.constants.AliasConstants.EXCEPTION_EMPTY_DATABASE;

public class EmptyDatabaseException extends BaseException {

    public EmptyDatabaseException(String serviceName) {
        super(EXCEPTION_EMPTY_DATABASE.formatted(serviceName), new Throwable());
    }
}
