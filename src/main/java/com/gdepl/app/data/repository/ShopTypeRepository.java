package com.gdepl.app.data.repository;

import com.gdepl.app.data.entity.ShopType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopTypeRepository extends JpaRepository<ShopType, UUID> {
}
