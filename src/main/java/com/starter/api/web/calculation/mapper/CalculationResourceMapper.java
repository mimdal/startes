package com.starter.api.web.calculation.mapper;

import com.starter.api.expose.request.SumRequest;
import com.starter.api.expose.response.SumResponse;
import com.starter.model.calculation.SumDto;
import org.springframework.stereotype.Repository;

@Repository
public class CalculationResourceMapper {

    public SumDto toSumDto(SumRequest request) {
        SumDto returnValue = new SumDto();
        returnValue.setA(Integer.parseInt(request.getNumberOne()));
        returnValue.setB(Integer.parseInt(request.getNumberTwo()));
        return returnValue;
    }

    public SumResponse toSumResponse(int number) {
        SumResponse returnValue = new SumResponse();
        returnValue.setResult(String.valueOf(number));
        return returnValue;
    }
}
