package com.cybersoft.DemoJPA.service.Imp;

import com.cybersoft.DemoJPA.dto.UsersDTO;
import com.cybersoft.DemoJPA.entity.Users;

import java.util.List;

public interface UsersService {
    boolean addUsers(UsersDTO usersDTO);
    Users getUsersByEmailAndPassword(String email, String password);
    List<UsersDTO> getAllUsers();
    List<UsersDTO> getUsersByEmailAndRoleName(String email, String roleName);
}
