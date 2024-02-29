package ru.sharphurt.newsstorage.service.sql;

import ru.sharphurt.newsstorage.dto.request.UpdateNewsDescriptionDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsTitleDto;

public interface UpdateNewsService {

    void updateNewsTitleById(String guid, UpdateNewsTitleDto dto);

    void updateNewsDescriptionById(String guid, UpdateNewsDescriptionDto dto);
}
