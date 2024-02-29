package ru.sharphurt.newsstorage.service.sql;

import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import java.util.List;

public interface UploadNewsService {

    void saveNews(List<NewsInformationDto> news);
}
