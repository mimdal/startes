package com.starter.model.calculation.dao;

import com.starter.model.calculation.entity.relation.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {
}