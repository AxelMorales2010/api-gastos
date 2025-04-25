package com.ax94.apigastos.service;

import com.ax94.apigastos.model.dto.UserDTO;
import com.ax94.apigastos.model.entity.AppUser;

import java.util.List;


public interface UserService {
    UserDTO createUser(UserDTO usuario);

    AppUser findUserById(Long id);

    List<AppUser> findAllUsers();
}
