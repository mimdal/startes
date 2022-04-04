package com.starter.model.calculation.dao;

import com.starter.model.calculation.entity.Sum;
import org.springframework.data.repository.CrudRepository;

public interface SumDao extends CrudRepository<Sum, Integer> {
}
