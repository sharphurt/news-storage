package ru.sharphurt.newsstorage.service.sql;

public interface DeleteNewsService {

    void deleteAll();

    void deleteByGuid(String guid);
}
