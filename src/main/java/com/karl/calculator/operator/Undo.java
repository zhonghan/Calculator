package com.karl.calculator.operator;

import com.karl.calculator.base.IndexValue;
import com.karl.calculator.base.OperationEnum;
import com.karl.calculator.base.OperationHolder;

import java.util.List;
import java.util.Stack;

/**
 * Created by karl on 2018/11/19.
 */
public class Undo extends Operation {

    public Undo(List<String> express, int operationIndex) {
        this.setIndexValue(new IndexValue(operationIndex, express.get(operationIndex)));
        this.setSymbol(OperationEnum.UNDO);
    }

    @Override
    public void calculate() {
        int operationIndex = this.getIndexValue().getIndex();
        Stack<Operation> stack = OperationHolder.getInstance().getOperationStack();

        if(!stack.isEmpty()) {
            Operation operation = stack.pop();
            this.getExpress().addAll(operationIndex + 1, operation.getParams());
        }
        this.getExpress().remove(operationIndex);
        if(operationIndex>0) {
            this.getExpress().remove(operationIndex - 1);
        }
    }

    @Override
    protected boolean invalidate() {
        return false;
    }
}
