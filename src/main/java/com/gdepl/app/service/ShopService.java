package com.gdepl.app.service;

import com.gdepl.app.data.dto.ShopDto;
import com.gdepl.app.data.mapper.ShopMapper;
import com.gdepl.app.data.repository.ShopRepository;
import com.gdepl.app.data.repository.ShopTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopTypeRepository shopTypeRepository;
    private final ShopMapper shopMapper;

    public ShopDto getShopById(UUID id) {
        var shop = shopRepository.findById(id).orElseThrow();
        return shopMapper.toDto(shop);

    }

    public List<ShopDto> getShopList() {
        return shopRepository.findAll()
                .stream()
                .map(shopMapper::toDto)
                .toList();
    }

    public ShopDto create(ShopDto shopDto) {
        var entity = shopMapper.toEntity(shopDto);
        var shopType = shopTypeRepository.findById(shopDto.shopTypeId()).orElseThrow();
        entity.setShopType(shopType);
        return shopMapper.toDto(shopRepository.save(entity));
    }

    public ShopDto update(UUID id, ShopDto shopDto) {
        var shop = shopRepository.findById(id).orElseThrow();
        shopMapper.update(shop, shopDto);
        if (!shop.getShopType().getId().equals(shopDto.shopTypeId())) {
            var shopType = shopTypeRepository.findById(shopDto.shopTypeId()).orElseThrow();
            shop.setShopType(shopType);
        }
        return shopMapper.toDto(shopRepository.save(shop));
    }

    public void delete(UUID id) {
        shopRepository.deleteById(id);
    }


}
