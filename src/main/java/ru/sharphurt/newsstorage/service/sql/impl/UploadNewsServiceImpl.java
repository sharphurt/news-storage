package ru.sharphurt.newsstorage.service.sql.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.repository.NewsRepository;
import ru.sharphurt.newsstorage.service.sql.UploadNewsService;

import java.util.List;

import static ru.sharphurt.newsstorage.mapper.NewsEntityMapper.NEWS_ENTITY_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadNewsServiceImpl implements UploadNewsService {

    private final NewsRepository newsRepository;

    public void saveNews(List<NewsInformationDto> newsList) {
        newsRepository.saveAll(NEWS_ENTITY_MAPPER.mapToEntitiesCollection(newsList));
    }
}
