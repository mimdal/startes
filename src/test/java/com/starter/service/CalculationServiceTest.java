package com.starter.service;

import com.starter.model.calculation.SumDto;
import com.starter.service.impl.CalculationServiceImpl;
import org.junit.jupiter.api.*;

class CalculationServiceTest {

    private CalculationService sut;

    @BeforeEach
    void setUp() {
        sut = new CalculationServiceImpl();
    }

    @Test
    @DisplayName("when two digits passed, then sum of two numbers returned")
    void whenTwoDigitsPassed_thenSumOfTwoNumbersReturned(TestInfo testInfo) {
        String scenarioName = testInfo.getDisplayName();
        String methodName = testInfo.getTestMethod().get().getName();

        SumDto sumDto = new SumDto();
        sumDto.setA(10);
        sumDto.setB(10);

        int calculatedValue = sut.sum(sumDto);

        Assertions.assertEquals(20, calculatedValue, scenarioName);
    }

    @Test
    @DisplayName("when at least one of digits is null, then sum of two numbers returned")
    void whenOneDigitsPassedIsNull_thenExceptionReturned(TestInfo testInfo) {
        String scenarioName = testInfo.getDisplayName();

        SumDto sumDto = new SumDto();
        sumDto.setA(null);
        sumDto.setB(10);

        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> sut.sum(sumDto),
                scenarioName);
        //thrown object may be used to for example exception message or something else.
    }
}