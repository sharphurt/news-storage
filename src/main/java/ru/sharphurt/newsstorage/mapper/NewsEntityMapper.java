package ru.sharphurt.newsstorage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.entity.NewsEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsEntityMapper {

    NewsEntityMapper NEWS_ENTITY_MAPPER = Mappers.getMapper(NewsEntityMapper.class);

    NewsInformationDto mapFromEntity(NewsEntity entity);

    @Mapping(source = "publicationDate", target = "timezoneId", qualifiedByName = "timezoneConverter")
    NewsEntity mapToEntity(NewsInformationDto dto);

    @Named("timezoneConverter")
    default String convertZonedDatetimeToTimezoneId(ZonedDateTime dateTime) {
        return dateTime.getZone().getId();
    }

    List<NewsEntity> mapToEntitiesCollection(List<NewsInformationDto> informationDtoList);

    List<NewsInformationDto> mapFromEntitiesCollection(List<NewsEntity> entities);
}
