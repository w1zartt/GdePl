package com.gdepl.app.data.dto;

import java.util.UUID;

public record ShopDto(
        UUID id,

        String name,

        String description,

        String address,

        UUID shopTypeId
) {
}
