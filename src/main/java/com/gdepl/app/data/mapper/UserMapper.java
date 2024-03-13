package com.gdepl.app.data.mapper;

import com.gdepl.app.data.dto.UserDto;
import com.gdepl.app.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    User updateEntity(@MappingTarget User user, UserDto userDto);

    UserDto toDto(User user);

}
