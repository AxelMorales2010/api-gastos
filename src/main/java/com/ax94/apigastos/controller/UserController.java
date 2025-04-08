package com.ax94.apigastos.controller;

import com.ax94.apigastos.model.dto.UserDTO;
import com.ax94.apigastos.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/crear")
    public UserDTO save(@RequestBody UserDTO usuario) {
      return  userService.createUser(usuario);
    }
}
