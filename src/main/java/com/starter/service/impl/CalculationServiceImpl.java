package com.starter.service.impl;

import com.starter.model.calculation.SumDto;
import com.starter.model.calculation.dao.SumDao;
import com.starter.model.calculation.entity.Sum;
import com.starter.service.CalculationService;
import com.starter.service.CalculationServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Autowired
    private SumDao sumDao;

    @Autowired
    private CalculationServiceMapper mapper;

    @Override
    public Integer sum(SumDto sumDto) {
        Integer result = sumDto.getA() + sumDto.getB();
        Sum sumEntity = mapper.toSum(sumDto, result);
        sumDao.save(sumEntity);
        return result;
    }

}
