package com.gdepl.app.data.mapper;

import com.gdepl.app.data.dto.ShopDto;
import com.gdepl.app.data.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShopMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shopType", ignore = true )
    Shop toEntity(ShopDto shopDto);

    @Mapping(target = "shopTypeId", source = "shopType.id")
    ShopDto toDto(Shop shop);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shopType", ignore = true)
    Shop update(@MappingTarget Shop shop, ShopDto shopType);
}
