package com.starter.model.calculation.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUM")
public class Sum {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "NUMBER_ONE")
    private Integer numberOne;

    private Integer numberTwo;

    private Integer result;

    public Integer getId() {
        return id;
    }

    public Sum setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getNumberOne() {
        return numberOne;
    }

    public Sum setNumberOne(Integer numberOne) {
        this.numberOne = numberOne;
        return this;
    }

    public Integer getNumberTwo() {
        return numberTwo;
    }

    public Sum setNumberTwo(Integer numberTwo) {
        this.numberTwo = numberTwo;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public Sum setResult(Integer result) {
        this.result = result;
        return this;
    }
}
