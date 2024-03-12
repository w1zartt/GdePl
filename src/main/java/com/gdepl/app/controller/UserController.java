package com.gdepl.app.controller;


import com.gdepl.app.data.dto.UserDto;
import com.gdepl.app.service.UserService;
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
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID  id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}