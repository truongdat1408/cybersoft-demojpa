package com.cybersoft.DemoJPA.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "sub_job")
public class JobsUsers {
    @EmbeddedId
    IdJobsUsers idJobsUsers;
}
