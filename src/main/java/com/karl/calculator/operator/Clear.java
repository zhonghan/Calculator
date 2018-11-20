package com.karl.calculator.operator;

import com.karl.calculator.base.IndexValue;
import com.karl.calculator.base.OperationEnum;
import com.karl.calculator.base.OperationHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public class Clear extends Operation {
    public Clear(List<String> express, int operationIndex) {
        this.setExpress(express);
        this.setIndexValue(new IndexValue(operationIndex, express.get(operationIndex)));
        this.setParams(new ArrayList<String>(express.subList(0, operationIndex)));
        this.setSymbol(OperationEnum.CLEAR);
        OperationHolder.getInstance().getOperationStack().add(this);
    }

    @Override
    public void calculate() {
        int index = this.getIndexValue().getIndex();
        for(int i=index;i>=0 ;i--) {
            this.getExpress().remove(i);
        }
    }

    @Override
    protected boolean invalidate() {
        return false;
    }
}
