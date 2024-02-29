package ru.sharphurt.newsstorage.exception;

import static ru.sharphurt.newsstorage.constants.AliasConstants.EXCEPTION_ENTITY_NOT_FOUND;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String serviceName, String id) {
        super(EXCEPTION_ENTITY_NOT_FOUND.formatted(serviceName, id), new Throwable());
    }
}
