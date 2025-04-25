package com.ax94.apigastos.controller;

import com.ax94.apigastos.model.dto.UserDTO;
import com.ax94.apigastos.model.entity.AppUser;

import com.ax94.apigastos.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public List<AppUser> getUserById() {
        List<AppUser> user = userService.findAllUsers();

        return user;
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        AppUser user = userService.findUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/crear")
    public UserDTO save(@RequestBody UserDTO usuario) {
      return  userService.createUser(usuario);
    }
}
