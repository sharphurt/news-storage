package ru.sharphurt.newsstorage.service.sql.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.exception.EmptyDatabaseException;
import ru.sharphurt.newsstorage.exception.EntityNotFoundException;
import ru.sharphurt.newsstorage.repository.NewsRepository;
import ru.sharphurt.newsstorage.service.sql.GetNewsService;

import java.util.List;

import static ru.sharphurt.newsstorage.mapper.NewsEntityMapper.NEWS_ENTITY_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetNewsServiceImpl implements GetNewsService {

    private final NewsRepository repository;

    private final String serviceName = "get-news-service";

    public NewsInformationDto getLastPublished() {
        var entity = repository.findFirstByOrderByPublicationDateDesc().orElseThrow(() -> new EmptyDatabaseException(serviceName));

        return NEWS_ENTITY_MAPPER.mapFromEntity(entity);
    }

    public NewsInformationDto getById(String guid) {
        var entity = repository.findById(guid).orElseThrow(() -> new EntityNotFoundException(serviceName, guid));

        return NEWS_ENTITY_MAPPER.mapFromEntity(entity);
    }

    @Override
    public List<NewsInformationDto> getAll() {
        return NEWS_ENTITY_MAPPER.mapFromEntitiesCollection(repository.findAll());
    }
}
