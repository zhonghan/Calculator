package com.karl.calculator.operator;

import com.karl.calculator.base.IndexValue;
import com.karl.calculator.base.OperationHolder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karl on 2018/11/20.
 */
public abstract class BaseMathOperation extends Operation {
    public BaseMathOperation(List<String> express, int operationIndex) {
        this.setIndexValue(new IndexValue(operationIndex, express.get(operationIndex)));
        this.setParams(new ArrayList<String>(express.subList(0, operationIndex)));
        this.setExpress(express);
        OperationHolder.getInstance().getOperationStack().add(this);
    }

    @Override
    public void calculate() {
        int operationIndex = this.getIndexValue().getIndex();
        BigDecimal result = concreteCalculate(new BigDecimal(this.getExpress().get(operationIndex - 2)),new BigDecimal(this.getExpress().get(operationIndex - 1)));
        this.getExpress().remove(operationIndex);
        this.getExpress().remove(operationIndex - 1);
        this.getExpress().remove(operationIndex - 2);
        this.getExpress().add(operationIndex - 2, result.toString());
    }
    protected abstract BigDecimal concreteCalculate(BigDecimal first, BigDecimal second) ;
}
