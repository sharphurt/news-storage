package ru.sharphurt.newsstorage.service.sql.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsDescriptionDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsTitleDto;
import ru.sharphurt.newsstorage.exception.EntityNotFoundException;
import ru.sharphurt.newsstorage.repository.NewsRepository;
import ru.sharphurt.newsstorage.service.sql.UpdateNewsService;

@Service
@RequiredArgsConstructor
public class UpdateNewsServiceImpl implements UpdateNewsService {

    private final NewsRepository repository;

    private final String serviceName = "update-news-service";

    public void updateNewsTitleById(String guid, UpdateNewsTitleDto dto) {
        var entity = repository.findById(guid).orElseThrow(() -> new EntityNotFoundException(serviceName, guid));
        entity.setTitle(dto.getTitle());
        repository.save(entity);
    }

    public void updateNewsDescriptionById(String guid, UpdateNewsDescriptionDto dto) {
        var entity = repository.findById(guid).orElseThrow(() -> new EntityNotFoundException(serviceName, guid));
        entity.setDescription(dto.getDescription());
        repository.save(entity);
    }
}
