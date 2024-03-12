package com.gdepl.app.data.dto;

import java.util.Set;
import java.util.UUID;

public record UserDto(
        UUID id,
        String login,
        String password,
        String firstName,
        String lastName,
        String country,
        Set<UserRole> roles
) {
}
