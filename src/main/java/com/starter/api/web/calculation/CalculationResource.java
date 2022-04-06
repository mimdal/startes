package com.starter.api.web.calculation;

import com.starter.api.expose.request.SumRequest;
import com.starter.api.expose.response.SumResponse;
import com.starter.api.web.calculation.mapper.CalculationResourceMapper;
import com.starter.service.calculation.CalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculations")
public class CalculationResource {

    private CalculationResourceMapper mapper;

    private CalculationService service;

    public CalculationResource(CalculationResourceMapper mapper, CalculationService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest request) {
        return ResponseEntity.ok(mapper.toSumResponse(service.sum(mapper.toSumDto(request))));
    }

}
