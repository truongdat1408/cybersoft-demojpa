package com.cybersoft.DemoJPA.service;

import com.cybersoft.DemoJPA.dto.UsersDTO;
import com.cybersoft.DemoJPA.entity.Roles;
import com.cybersoft.DemoJPA.entity.Users;
import com.cybersoft.DemoJPA.repository.RolesRepository;
import com.cybersoft.DemoJPA.repository.UsersRepository;
import com.cybersoft.DemoJPA.service.Imp.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public boolean addUsers(UsersDTO usersDTO) {
        Users users = new Users();
        Roles role = new Roles();
        role.setId(usersDTO.getRoleId());

        users.setAvatar(usersDTO.getAvatar());
        users.setEmail(usersDTO.getEmail());
        users.setFullname(usersDTO.getFullname());
        users.setPassword(usersDTO.getPassword());
        users.setRoles(role);

        try {
            usersRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Users getUsersByEmailAndPassword(String email, String password) {
        return usersRepository.findUsersByEmailAndPassword(email, password);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<UsersDTO> usersDTOS = new ArrayList<>();

        List<Users> users = usersRepository.getAllUsers();
        return transferUsersToUsersDTO(usersDTOS, users);
    }

    @Override
    public List<UsersDTO> getUsersByEmailAndRoleName(String email, String roleName) {
        List<UsersDTO> usersDTOS = new ArrayList<>();

        List<Users> users = usersRepository.getUsersByEmailAndRoleName(email, roleName);
        return transferUsersToUsersDTO(usersDTOS, users);
    }

    private List<UsersDTO> transferUsersToUsersDTO(List<UsersDTO> usersDTOS, List<Users> users) {
        for (Users user : users) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setPassword(user.getPassword());
            usersDTO.setFullname(user.getFullname());
            usersDTO.setEmail(user.getEmail());
            usersDTO.setAvatar(user.getAvatar());
            usersDTO.setRoleId(user.getRoles().getId());

            usersDTOS.add(usersDTO);
        }

        return usersDTOS;
    }
}
