package com.starter.service;

import com.starter.model.calculation.SumDto;
import com.starter.model.calculation.entity.Sum;
import org.springframework.stereotype.Repository;

@Repository
public class CalculationServiceMapper {

    public Sum toSum(SumDto sumDto, Integer result) {
        Sum returnObject = new Sum();
        returnObject.setNumberOne(sumDto.getA())
                .setNumberTwo(sumDto.getB())
                .setResult(result);
        return returnObject;
    }

}
