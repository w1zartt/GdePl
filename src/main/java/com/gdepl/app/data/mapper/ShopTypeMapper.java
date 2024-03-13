package com.gdepl.app.data.mapper;

import com.gdepl.app.data.dto.ShopTypeDto;
import com.gdepl.app.data.entity.ShopType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShopTypeMapper {

    @Mapping(target = "id", ignore = true)
    ShopType toEntity(ShopTypeDto shopTypeDto);

    ShopTypeDto toDto(ShopType shopType);

    @Mapping(target = "id", ignore = true)
    ShopType update(@MappingTarget ShopType shopType, ShopTypeDto shopTypeDto);
}
