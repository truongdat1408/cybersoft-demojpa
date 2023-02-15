package com.cybersoft.DemoJPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private Set<Tasks> tasks;

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
