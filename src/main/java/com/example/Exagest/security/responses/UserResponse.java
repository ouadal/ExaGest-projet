package com.example.Exagest.security.responses;

import com.example.Exagest.security.entities.Role;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
@RequiredArgsConstructor
@Data
public class UserResponse {

    private String username;

    private boolean isNotLocked;

    private boolean isEnable;

    private Collection<Role> roles;

    private Object informations;

}
