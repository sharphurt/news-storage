package ru.sharphurt.newsstorage.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.dto.api.ControllerResponse;
import ru.sharphurt.newsstorage.repository.NewsRepository;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.sharphurt.newsstorage.sample.NewsSample.*;

@SpringBootTest
class NewsStorageControllerTest extends BaseSpringContextTest {

    @Autowired
    private NewsRepository repository;

    @AfterEach
    @BeforeEach
    public void afterEach() {
        repository.deleteAll();
    }

    @SneakyThrows
    @Test
    public void uploadNews_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"))
                .andReturn().getResponse();
    }

    @SneakyThrows
    @Test
    public void uploadNews_emptyList_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_empty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));
    }


    @SneakyThrows
    @Test
    public void uploadNews_alreadyExisted_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(List.of(newsList_correct.get(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        var getResponse = mvc.perform(get("/api"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();

        var result = objectMapper.readValue(getResponse, GetNewsStructureDto.class).getResult();
        assertEquals(objectMapper.writeValueAsString(newsList_correct), objectMapper.writeValueAsString(result));
    }


    @SneakyThrows
    @Test
    public void patchNewsTitle_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        mvc.perform(patch("/api/guid2/title")
                        .content(objectMapper.writeValueAsString(updateTitleDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        var getResponse = mvc.perform(get("/api"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();


        var result = objectMapper.readValue(getResponse, GetNewsStructureDto.class).getResult();
        var updated = result.stream().filter(e -> Objects.equals(e.getGuid(), "guid2")).findFirst();

        assertEquals(4, result.size());
        assertEquals("updated", updated.get().getTitle());
    }

    @SneakyThrows
    @Test
    public void patchNewsDescription_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        mvc.perform(patch("/api/guid2/description")
                        .content(objectMapper.writeValueAsString(updateDescriptionDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        var getResponse = mvc.perform(get("/api"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();

        var result = objectMapper.readValue(getResponse, GetNewsStructureDto.class).getResult();
        var updated = result.stream().filter(e -> Objects.equals(e.getGuid(), "guid2")).findFirst();

        assertEquals(4, result.size());
        assertEquals("updated", updated.get().getDescription());
    }


    @SneakyThrows
    @Test
    public void deleteByIdNews_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        mvc.perform(delete("/api/guid2"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        var getResponse = mvc.perform(get("/api"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();

        var result = objectMapper.readValue(getResponse, GetNewsStructureDto.class).getResult();

        assertEquals(3, result.size());
        assertFalse(result.stream().anyMatch(e -> Objects.equals(e.getGuid(), "guid2")));
    }

    @SneakyThrows
    @Test
    public void deleteAllNews_successTest() {
        mvc.perform(post("/api")
                        .content(objectMapper.writeValueAsString(newsList_correct))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        mvc.perform(delete("/api/all"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("successful").value("true"));

        var getResponse = mvc.perform(get("/api"))
                .andExpect(status().is(200))
                .andReturn().getResponse().getContentAsString();

        var result = objectMapper.readValue(getResponse, GetNewsStructureDto.class).getResult();

        assertEquals(0, result.size());
    }


    private static class GetNewsStructureDto extends ControllerResponse<List<NewsInformationDto>> {
    }
}
