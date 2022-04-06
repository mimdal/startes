package com.starter.model.calculation.entity.relation;

import javax.persistence.*;

@Entity
@Table(name = "HEADMASTER")
public class HeadMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "headMaster", orphanRemoval = true)
    private School school;

    /**
     * getters and setters section
     */

    public Integer getId() {
        return id;
    }

    public HeadMaster setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeadMaster setName(String name) {
        this.name = name;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
