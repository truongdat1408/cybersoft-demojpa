package com.cybersoft.DemoJPA.controller;

import com.cybersoft.DemoJPA.dto.UsersDTO;
import com.cybersoft.DemoJPA.entity.Users;
import com.cybersoft.DemoJPA.payload.LoginRequest;
import com.cybersoft.DemoJPA.service.Imp.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUsersByEmailAndRoleName")
    public ResponseEntity<?> getUsersByEmailAndRoleName(
            @RequestParam String email,
            @RequestParam String roleName
    ) {
        return new ResponseEntity<>(usersService.getUsersByEmailAndRoleName(email, roleName), HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<?> addUsers(@RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.addUsers(usersDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Users user = usersService.getUsersByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(user != null, HttpStatus.OK);
    }
}
