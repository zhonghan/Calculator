package com.karl.calculator.operator;

import com.karl.calculator.base.OperationEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public class Addition extends BaseMathOperation {
    public Addition(List<String> express, int operationIndex) {
        super(express, operationIndex);
        this.setSymbol(OperationEnum.ADDITION);
    }

    @Override
    protected BigDecimal concreteCalculate(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    @Override
    protected boolean invalidate() {
        return this.getIndexValue().getIndex() < 2;
    }


}
