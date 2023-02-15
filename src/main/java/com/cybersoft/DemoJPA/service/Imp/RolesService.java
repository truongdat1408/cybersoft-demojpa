package com.cybersoft.DemoJPA.service.Imp;

import com.cybersoft.DemoJPA.dto.RolesDTO;

import java.util.List;

public interface RolesService {
    List<RolesDTO> getAllRoles();
    List<RolesDTO> getAllByName(String name);
}
