package com.gdepl.app.controller;

import com.gdepl.app.data.dto.ShopDto;
import com.gdepl.app.service.ShopService;
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
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShop(@PathVariable UUID id) {
        return new ResponseEntity<>(shopService.getShopById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ShopDto>> getShopList() {
        return new ResponseEntity<>(shopService.getShopList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto) {
        return new ResponseEntity<>(shopService.create(shopDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopDto> updateShop(@PathVariable UUID id, @RequestBody ShopDto shopDto) {
        return new ResponseEntity<>(shopService.update(id, shopDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable UUID id) {
        shopService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
