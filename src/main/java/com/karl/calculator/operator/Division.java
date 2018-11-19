package com.karl.calculator.operator;

import com.karl.calculator.base.OperationEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public class Division extends BaseMathOperation {
    public Division(List<String> express, int operationIndex) {
        super(express, operationIndex);
        this.setSymbol(OperationEnum.DIVISION);
    }

    @Override
    protected BigDecimal concreteCalculate(BigDecimal first, BigDecimal second) {
        return first.divide(second, 15, RoundingMode.CEILING);
    }

    @Override
    protected boolean invalidate() {
        return this.getIndexValue().getIndex() < 2;
    }
}
