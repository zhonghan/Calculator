package com.karl.calculator.base;

import com.karl.calculator.operator.Operation;

import java.util.Stack;

/**
 * Created by karl on 2018/11/19.
 */
public class OperationHolder {
    private Stack<Operation> operationStack;

    public Stack<Operation> getOperationStack() {
        return operationStack;
    }
    private volatile static OperationHolder instance = null;
    private OperationHolder(){
        operationStack = new Stack<Operation>();
    }
    public static OperationHolder getInstance(){
        if(instance == null){
            synchronized (OperationHolder.class){
                if(instance == null){
                    instance = new OperationHolder();
                }
            }
        }
        return instance;
    }
}
