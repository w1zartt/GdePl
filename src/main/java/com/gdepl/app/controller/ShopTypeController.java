package com.gdepl.app.controller;

import com.gdepl.app.data.dto.ShopTypeDto;
import com.gdepl.app.service.ShopTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("shop-type")
@RequiredArgsConstructor
public class ShopTypeController {

    private final ShopTypeService shopTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<ShopTypeDto> getShopType(@PathVariable UUID id) {
        return new ResponseEntity<>(shopTypeService.getShopTypeById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShopTypeDto>> getShopTypeList() {
        return new ResponseEntity<>(shopTypeService.getShopTypeList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopTypeDto> createShopType(@RequestBody ShopTypeDto shopTypeDto) {
        return new ResponseEntity<>(shopTypeService.create(shopTypeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopTypeDto> updateShopType(@PathVariable UUID id, @RequestBody ShopTypeDto shopTypeDto) {
        return new ResponseEntity<>(shopTypeService.update(id, shopTypeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShopType(@PathVariable UUID id) {
        shopTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
