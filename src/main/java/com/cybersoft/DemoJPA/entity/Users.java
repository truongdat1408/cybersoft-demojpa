package com.cybersoft.DemoJPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "avatar")
    private String avatar;

//    @Column(name = "role_id")
//    private int roldId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<Tasks> tasks;

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
