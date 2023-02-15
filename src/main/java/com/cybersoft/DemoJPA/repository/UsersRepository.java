package com.cybersoft.DemoJPA.repository;

import com.cybersoft.DemoJPA.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findUsersByEmailAndPassword(String email, String password);

    /*
    * @Query: Đây là câu query viết bằng JSQL câu query này sẽ tương tác với class Entity
    * value: cau query
    * nativeQuery = true: Lấy dữ liệu 2 cột được và tương tác với câu query của native
    * */
    @Query("select u from users as u")
    List<Users> getAllUsers();

    @Query("select u from users u join roles r on u.roles.id = r.id where u.email = ?1 and r.name = ?2")
    List<Users> getUsersByEmailAndRoleName(String email, String roleName);
}
