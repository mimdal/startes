package com.starter.service.relation.impl;

import com.starter.model.calculation.dao.SchoolRepository;
import com.starter.model.calculation.dao.StudentRepository;
import com.starter.model.calculation.dao.TeacherRepository;
import com.starter.model.calculation.entity.relation.HeadMaster;
import com.starter.model.calculation.entity.relation.School;
import com.starter.model.calculation.entity.relation.Student;
import com.starter.model.calculation.entity.relation.Teacher;
import com.starter.service.relation.EntityRelationService;
import com.starter.service.relation.mapper.EntityRelationServiceMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EntityRelationServiceImpl implements EntityRelationService {

    public EntityRelationServiceImpl(EntityRelationServiceMapper mapper, SchoolRepository schoolRepository, TeacherRepository teacherRepository,
                                     StudentRepository studentRepository) {
        this.mapper = mapper;
        this.schoolRepository = schoolRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    private EntityRelationServiceMapper mapper;

    private SchoolRepository schoolRepository;

    private TeacherRepository teacherRepository;

    private StudentRepository studentRepository;

    @Override
    public String persist() {
        HeadMaster headMaster = mapper.getRandomHeadMaster();
        School school = mapper.getRandomSchool(headMaster);
        schoolRepository.save(school);
        String[] fields = {"not-used", "physics", "mathematics", "chemistry", "literature", "music"};
        Teacher[] teachers = new Teacher[5];
        for (int i = 1; i < 5; i++) {
            Teacher teacher = mapper.getRandomTeacher(school, fields[i]);
            teachers[i-1] = teacher;
            teacherRepository.save(teacher);
        }

        for (int i = 1; i < 3; i++) {
           Student student = mapper.getRandomStudent(Arrays.asList(teachers));
            studentRepository.save(student);
        }
        return "see-database-tables: headMaster-school-teacher-student";
    }

}
