package ru.sharphurt.newsstorage.dto.api;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@EqualsAndHashCode(callSuper = true)
public class ControllerEmptySuccessResponse extends ResponseEntity<ControllerResponse<Object>> {

    private ControllerEmptySuccessResponse() {
        super(ControllerResponse.builder().successful(true).error(null).result(null).build(), HttpStatus.OK);
    }

    public static ControllerEmptySuccessResponse create() {
        return new ControllerEmptySuccessResponse();
    }
}