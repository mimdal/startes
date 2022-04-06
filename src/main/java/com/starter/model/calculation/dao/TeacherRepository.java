package com.starter.model.calculation.dao;

import com.starter.model.calculation.entity.relation.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}