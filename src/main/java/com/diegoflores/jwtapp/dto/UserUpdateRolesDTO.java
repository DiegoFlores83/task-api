package com.diegoflores.jwtapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRolesDTO {
    private Set<String> roles; // ["ADMIN", "USER"]
}
