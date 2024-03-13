package com.gdepl.app.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "shop_type")
@Getter
@Setter
public class ShopType {

    @Id
    @UuidGenerator
    private UUID id;

    private String code;

    private String description;

}
