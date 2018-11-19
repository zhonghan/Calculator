package com.karl.calculator.operator;

import com.karl.calculator.base.IndexValue;
import com.karl.calculator.base.OperationEnum;
import com.karl.calculator.base.OperationHolder;

import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public class Sqrt extends Operation {
    public Sqrt(List<String> express, int operationIndex) {
        this.setExpress(express);
        this.setIndexValue(new IndexValue(operationIndex, express.get(operationIndex)));
        this.getParams().add(express.get(operationIndex - 1));
        this.setSymbol(OperationEnum.SQRT);
        OperationHolder.getInstance().getOperationStack().add(this);
    }

    @Override
    public void calculate() {
        int operationIndex = this.getIndexValue().getIndex();
        Double result = Math.sqrt(Double.valueOf(this.getExpress().get(operationIndex - 1)));
        this.getExpress().remove(operationIndex);
        this.getExpress().remove(operationIndex - 1);
        this.getExpress().add(operationIndex - 1, result.toString());
    }

    @Override
    protected boolean invalidate() {
        return this.getIndexValue().getIndex() < 1;
    }
}
