package com.cybersoft.DemoJPA.repository;

import com.cybersoft.DemoJPA.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    List<Roles> findAllByName(String name);
    Roles findByName(String name);
}
