package com.starter.api.expose.request;

public class SumRequest {

    private String numberOne;

    private String numberTwo;

    public String getNumberOne() {
        return numberOne;
    }

    public SumRequest setNumberOne(String numberOne) {
        this.numberOne = numberOne;
        return this;
    }

    public String getNumberTwo() {
        return numberTwo;
    }

    public SumRequest setNumberTwo(String numberTwo) {
        this.numberTwo = numberTwo;
        return this;
    }

}
