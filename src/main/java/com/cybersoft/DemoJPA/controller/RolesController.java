package com.cybersoft.DemoJPA.controller;

import com.cybersoft.DemoJPA.service.Imp.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;

    @GetMapping("")
    public ResponseEntity<?> getAllRoles() {
        return new ResponseEntity<>(rolesService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAllRolesByName(@PathVariable String name) {
        return new ResponseEntity<>(rolesService.getAllByName(name), HttpStatus.OK);
    }
}
