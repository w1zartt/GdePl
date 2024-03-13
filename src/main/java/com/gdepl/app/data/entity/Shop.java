package com.gdepl.app.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "shop")
@Getter
@Setter
public class Shop {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private String description;

    private String address;

    @ManyToOne
    @JoinColumn(name = "shop_type")
    private ShopType shopType;
}
