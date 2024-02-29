package ru.sharphurt.newsstorage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class NewsEntity {

    @Id
    private String guid;
    private String title;
    private String description;
    private ZonedDateTime publicationDate;
}
