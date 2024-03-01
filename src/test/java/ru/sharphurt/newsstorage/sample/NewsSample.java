package ru.sharphurt.newsstorage.sample;

import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsDescriptionDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsTitleDto;

import java.time.ZonedDateTime;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class NewsSample {

    public static final List<NewsInformationDto> newsList_correct = List.of(
            new NewsInformationDto("guid1", "title", "description", ZonedDateTime.now(UTC)),
            new NewsInformationDto("guid2", "title", "description", ZonedDateTime.now(UTC).plusMinutes(1)),
            new NewsInformationDto("guid3", "title", "description", ZonedDateTime.now(UTC).plusMinutes(10)),
            new NewsInformationDto("guid4", "title", "description", ZonedDateTime.now(UTC).plusMinutes(20)));

    public static final UpdateNewsTitleDto updateTitleDto = UpdateNewsTitleDto.builder().title("updated").build();
    public static final UpdateNewsDescriptionDto updateDescriptionDto = UpdateNewsDescriptionDto.builder().description("updated").build();

    public static final List<NewsInformationDto> newsList_empty = List.of();
}
