package ru.sharphurt.newsstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sharphurt.newsstorage.serialization.ZonedDateTimeDeserializer;
import ru.sharphurt.newsstorage.serialization.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsInformationDto {

    private String guid;
    private String title;
    private String description;

    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime publicationDate;
}
