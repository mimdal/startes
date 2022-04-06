package com.starter.model.calculation.entity.relation;

import javax.persistence.*;

@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String filed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    /**
     * getters and setters section
     */
    public Integer getId() {
        return id;
    }

    public Teacher setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getFiled() {
        return filed;
    }

    public Teacher setFiled(String filed) {
        this.filed = filed;
        return this;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
