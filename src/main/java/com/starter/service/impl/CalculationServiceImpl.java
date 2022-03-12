package com.starter.service.impl;

import com.starter.model.calculation.SumDto;
import com.starter.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public Integer sum(SumDto sumDto) {
        return sumDto.getA() + sumDto.getB();
    }

}
