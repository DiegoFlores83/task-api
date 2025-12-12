package com.diegoflores.jwtapp.service;

import com.diegoflores.jwtapp.dto.UserCreateDTO;
import com.diegoflores.jwtapp.dto.UserDTO;
import com.diegoflores.jwtapp.dto.UserRegisterDTO;
import com.diegoflores.jwtapp.dto.UserUpdateRolesDTO;

import java.util.List;

public interface UserService {

    UserDTO register(UserRegisterDTO dto);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserCreateDTO dto);

    UserDTO updateUserRoles(Long userId, UserUpdateRolesDTO dto);

    void deleteUser(Long userId);
}
