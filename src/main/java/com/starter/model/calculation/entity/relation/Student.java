package com.starter.model.calculation.entity.relation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private Long numberId;

    @ManyToMany
    @JoinTable(name = "STUDENT_TEACHER",
            joinColumns = @JoinColumn(name = "STUDENT_id"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_id"))
    private List<Teacher> teachers;


    /**
     * getters and setters section
     */

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Long getNumberId() {
        return numberId;
    }

    public Student setNumberId(Long numberId) {
        this.numberId = numberId;
        return this;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
