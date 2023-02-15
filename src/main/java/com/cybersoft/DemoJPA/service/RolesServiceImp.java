package com.cybersoft.DemoJPA.service;

import com.cybersoft.DemoJPA.dto.RolesDTO;
import com.cybersoft.DemoJPA.entity.Roles;
import com.cybersoft.DemoJPA.repository.RolesRepository;
import com.cybersoft.DemoJPA.service.Imp.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImp implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Override
    public List<RolesDTO> getAllRoles() {
        List<Roles> rolesList = rolesRepository.findAll();
        List<RolesDTO> rolesDTOS = new ArrayList<>();

        for(Roles role : rolesList) {
            RolesDTO rolesDTO = new RolesDTO(role.getId(), role.getName(), role.getDesc());
            rolesDTOS.add(rolesDTO);
        }

        return rolesDTOS;
    }

    @Override
    public List<RolesDTO> getAllByName(String name) {
        List<Roles> rolesList = rolesRepository.findAllByName(name);
        List<RolesDTO> rolesDTOS = new ArrayList<>();

        for(Roles role : rolesList) {
            RolesDTO rolesDTO = new RolesDTO(role.getId(), role.getName(), role.getDesc());
            rolesDTOS.add(rolesDTO);
        }

        return rolesDTOS;
    }
}
