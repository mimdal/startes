package com.starter.model.calculation.entity.relation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCHOOL")
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false, orphanRemoval = true)
    @JoinColumn(name = "head_master_id", nullable = false)
    private HeadMaster headMaster;

    @OneToMany(mappedBy = "school", orphanRemoval = true)
    private List<Teacher> teachers;

    /**
     * getters and setters section
     */

    public Integer getId() {
        return id;
    }

    public School setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public School setName(String name) {
        this.name = name;
        return this;
    }

    public HeadMaster getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(HeadMaster headMaster) {
        this.headMaster = headMaster;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

}
