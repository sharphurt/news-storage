package ru.sharphurt.newsstorage.sample;

import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsDescriptionDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsTitleDto;

import java.time.LocalDateTime;
import java.util.List;

public class NewsSample {

    public static final List<NewsInformationDto> newsList_correct = List.of(
            new NewsInformationDto("guid1", "title", "description", LocalDateTime.now()),
            new NewsInformationDto("guid2", "title", "description", LocalDateTime.now()),
            new NewsInformationDto("guid3", "title", "description", LocalDateTime.now()),
            new NewsInformationDto("guid4", "title", "description", LocalDateTime.now()));

    public static final UpdateNewsTitleDto updateTitleDto = UpdateNewsTitleDto.builder().title("updated").build();
    public static final UpdateNewsDescriptionDto updateDescriptionDto = UpdateNewsDescriptionDto.builder().description("updated").build();

    public static final List<NewsInformationDto> newsList_empty = List.of();
}
