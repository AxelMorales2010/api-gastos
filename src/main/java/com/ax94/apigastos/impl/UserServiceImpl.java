package com.ax94.apigastos.impl;

import com.ax94.apigastos.model.dto.UserDTO;
import com.ax94.apigastos.model.entity.Usuario;
import com.ax94.apigastos.model.repository.UserRepository;
import com.ax94.apigastos.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

        Usuario user = new Usuario();
        user.setEmail(usuarioDTO.getEmail());
        user.setNombre(usuarioDTO.getNombre());
        user.setEmail(usuarioDTO.getEmail());
        user.setPassword(usuarioDTO.getPassword());
         return usuarioDTO;
    }
}
