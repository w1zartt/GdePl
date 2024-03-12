package com.gdepl.app.service;

import com.gdepl.app.data.dto.UserDto;
import com.gdepl.app.data.entity.User;
import com.gdepl.app.data.mapper.UserMapper;
import com.gdepl.app.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        var entity = userMapper.toEntity(userDto);
        var created = userRepository.save(entity);
        return userMapper.toDto(created);
    }


    public UserDto getUser(UUID id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow());
    }


    public List<UserDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto updateUser(UUID id, UserDto userDto) {
        var user = userRepository.findById(id).orElseThrow();
        userMapper.updateEntity(user, userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(UUID  id) {
        userRepository.deleteById(id);
    }


}
