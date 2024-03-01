package ru.sharphurt.newsstorage.service.cron;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.sharphurt.newsstorage.service.sql.DeleteNewsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClearDatabaseCronService {

    private DeleteNewsService deleteNewsService;

    @Scheduled(cron = "@daily")
    public void clearDatabaseOnNewDay() {
        deleteNewsService.deleteAll();
    }
}
