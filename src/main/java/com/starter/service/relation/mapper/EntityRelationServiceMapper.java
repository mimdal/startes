package com.starter.service.relation.mapper;

import com.starter.model.calculation.entity.relation.HeadMaster;
import com.starter.model.calculation.entity.relation.School;
import com.starter.model.calculation.entity.relation.Student;
import com.starter.model.calculation.entity.relation.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class EntityRelationServiceMapper {

    private int getRandomDigit() {
        return new Random().nextInt(900000000);
    }

    public School getRandomSchool(HeadMaster headMaster) {
        School school = new School();
        school.setName("Jills School - " + getRandomDigit());
        school.setHeadMaster(headMaster);
        return school;
    }

    public HeadMaster getRandomHeadMaster() {
        HeadMaster headMaster = new HeadMaster();
        headMaster.setName("Will EE -" + getRandomDigit());
        return headMaster;
    }

    public Teacher getRandomTeacher(School school, String filed) {
        Teacher teacher = new Teacher();
        teacher.setName("Mary Merry - " + getRandomDigit());
        teacher.setSchool(school);
        teacher.setFiled(filed);
        return teacher;
    }

    public Student getRandomStudent(List<Teacher> teacherList) {
        Student student = new Student();
        int randomNumber = getRandomDigit();
        student.setName("Jimmy Jammy - " + randomNumber);
        student.setNumberId((long) randomNumber);
        student.setTeachers(teacherList);
        return student;
    }
}
