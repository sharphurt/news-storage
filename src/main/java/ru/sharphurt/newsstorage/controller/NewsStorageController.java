package ru.sharphurt.newsstorage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.dto.api.ControllerEmptySuccessResponse;
import ru.sharphurt.newsstorage.dto.api.ControllerSuccessResponse;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsDescriptionDto;
import ru.sharphurt.newsstorage.dto.request.UpdateNewsTitleDto;
import ru.sharphurt.newsstorage.service.sql.DeleteNewsService;
import ru.sharphurt.newsstorage.service.sql.GetNewsService;
import ru.sharphurt.newsstorage.service.sql.UpdateNewsService;
import ru.sharphurt.newsstorage.service.sql.UploadNewsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NewsStorageController {

    private final UploadNewsService uploadNewsService;
    private final GetNewsService getNewsService;
    private final DeleteNewsService deleteNewsService;
    private final UpdateNewsService updateNewsService;

    @PostMapping
    public ControllerEmptySuccessResponse uploadNews(@RequestBody List<NewsInformationDto> body) {
        uploadNewsService.saveNews(body);
        return ControllerEmptySuccessResponse.create();
    }

    @GetMapping
    public ControllerSuccessResponse<List<NewsInformationDto>> getTodayNews() {
        return ControllerSuccessResponse.of(getNewsService.getAll());
    }

    @PatchMapping("/{guid}/title")
    public ControllerEmptySuccessResponse updateNewsTitle(@PathVariable("guid") String guid, @RequestBody UpdateNewsTitleDto body) {
        updateNewsService.updateNewsTitleById(guid, body);
        return ControllerEmptySuccessResponse.create();
    }

    @PatchMapping("/{guid}/description")
    public ControllerEmptySuccessResponse updateNewsDescription(@PathVariable("guid") String guid, @RequestBody UpdateNewsDescriptionDto body) {
        updateNewsService.updateNewsDescriptionById(guid, body);
        return ControllerEmptySuccessResponse.create();
    }

    @DeleteMapping("/{guid}")
    public ControllerEmptySuccessResponse deleteByGuid(@PathVariable("guid") String guid) {
        deleteNewsService.deleteByGuid(guid);
        return ControllerEmptySuccessResponse.create();
    }

    @DeleteMapping("/all")
    public ControllerEmptySuccessResponse deleteAll() {
        deleteNewsService.deleteAll();
        return ControllerEmptySuccessResponse.create();
    }
}
