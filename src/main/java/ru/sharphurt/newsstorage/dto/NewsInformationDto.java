package ru.sharphurt.newsstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sharphurt.newsstorage.serialization.LocalDateTimeDeserializer;
import ru.sharphurt.newsstorage.serialization.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsInformationDto {

    private String guid;
    private String title;
    private String description;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime publicationDate;
}
