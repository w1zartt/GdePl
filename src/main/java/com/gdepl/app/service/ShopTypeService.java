package com.gdepl.app.service;

import com.gdepl.app.data.dto.ShopTypeDto;
import com.gdepl.app.data.mapper.ShopTypeMapper;
import com.gdepl.app.data.repository.ShopTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShopTypeService {

    private final ShopTypeRepository shopTypeRepository;
    private final ShopTypeMapper shopTypeMapper;

    public ShopTypeDto create(ShopTypeDto shopTypeDto) {
        var entity = shopTypeMapper.toEntity(shopTypeDto);
        return shopTypeMapper.toDto(shopTypeRepository.save(entity));
    }

    public ShopTypeDto update(UUID id, ShopTypeDto shopTypeDto) {
        var shopType = shopTypeRepository.findById(id).orElseThrow();
        shopTypeMapper.update(shopType, shopTypeDto);
        return shopTypeMapper.toDto(shopTypeRepository.save(shopType));
    }

    public ShopTypeDto getShopTypeById(UUID id) {
        var shopType = shopTypeRepository.findById(id).orElseThrow();
        return shopTypeMapper.toDto(shopType);
    }

    public List<ShopTypeDto> getShopTypeList() {
        return shopTypeRepository.findAll()
                .stream()
                .map(shopTypeMapper::toDto)
                .toList();
    }

    public void delete(UUID id) {
        shopTypeRepository.deleteById(id);
    }

}
