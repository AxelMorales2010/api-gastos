package com.ax94.apigastos.impl;

import com.ax94.apigastos.model.dto.UserDTO;
import com.ax94.apigastos.model.entity.AppUser;

import com.ax94.apigastos.model.repository.UserRepository;
import com.ax94.apigastos.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDTO  createUser(UserDTO usuarioDTO) {
        if(userRepository.existsById(usuarioDTO.getId())) {
            throw new RuntimeException("usuario ya existe");
        }

        AppUser user = new AppUser();
        user.setEmail(usuarioDTO.getEmail());
        user.setNombre(usuarioDTO.getNombre());
        user.setPassword(usuarioDTO.getPassword());
        userRepository.save(user);
         return usuarioDTO;
    }

    @Override
    public AppUser findUserById(Long id) {
        return  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("usuario no encontrado"));
    }

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }
}
