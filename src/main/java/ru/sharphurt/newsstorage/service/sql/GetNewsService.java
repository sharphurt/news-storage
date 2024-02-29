package ru.sharphurt.newsstorage.service.sql;

import ru.sharphurt.newsstorage.dto.NewsInformationDto;

import java.util.List;

public interface GetNewsService {

    NewsInformationDto getLastPublished();
    NewsInformationDto getById(String guid);

    List<NewsInformationDto> getAll();
}
