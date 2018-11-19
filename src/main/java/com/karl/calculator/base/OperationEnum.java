package com.karl.calculator.base;

/**
 * Created by karl on 2018/11/19.
 */
public enum OperationEnum {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*") , DIVISION("/"), SQRT("sqrt"), CLEAR("clear"), UNDO("undo");
    private String symbol;

    OperationEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static boolean isOperator(String item) {
        for(OperationEnum operationEnum : OperationEnum.values()){
            if(operationEnum.getSymbol().equals(item)){
                return true;
            }
        }
        return false;
    }
}
