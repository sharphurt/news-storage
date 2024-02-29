package ru.sharphurt.newsstorage.service.sql.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.newsstorage.repository.NewsRepository;
import ru.sharphurt.newsstorage.service.sql.DeleteNewsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteNewsServiceImpl implements DeleteNewsService {

    private final NewsRepository repository;

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteByGuid(String guid) {
        repository.deleteById(guid);
    }
}
