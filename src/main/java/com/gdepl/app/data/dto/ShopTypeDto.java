package com.gdepl.app.data.dto;

import java.util.UUID;

public record ShopTypeDto(
        UUID id,
        String code,
        String description
) {
}
