package ru.sharphurt.newsstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import ru.sharphurt.newsstorage.serialization.ZonedDateTimeDeserializer;

@Data
public class NewsInformationDto {

    private String guid;
    private String title;
    private String description;

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private java.time.ZonedDateTime publicationDate;
}
