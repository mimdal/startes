package com.starter.model.calculation.dao;

import com.starter.model.calculation.entity.relation.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}