package ru.sharphurt.newsstorage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.sharphurt.newsstorage.dto.NewsInformationDto;
import ru.sharphurt.newsstorage.entity.NewsEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsEntityMapper {

    NewsEntityMapper NEWS_ENTITY_MAPPER = Mappers.getMapper(NewsEntityMapper.class);

    NewsInformationDto mapFromEntity(NewsEntity entity);

    NewsEntity mapToEntity(NewsInformationDto dto);

    List<NewsEntity> mapToEntitiesCollection(List<NewsInformationDto> informationDtoList);

    List<NewsInformationDto> mapFromEntitiesCollection(List<NewsEntity> entities);
}
