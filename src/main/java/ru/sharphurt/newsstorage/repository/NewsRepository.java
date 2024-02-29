package ru.sharphurt.newsstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sharphurt.newsstorage.entity.NewsEntity;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<NewsEntity, String> {

    Optional<NewsEntity> findFirstByOrderByPublicationDateDesc();
}
