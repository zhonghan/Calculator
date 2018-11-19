package com.karl.calculator.base;

import com.karl.calculator.operator.*;

import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public class OperationFactory {
    public static Operation findFirstOperation(List<String> list) {
        for(int i=0;i<list.size();i++){
            if(OperationEnum.CLEAR.getSymbol().equals(list.get(i))){
                return new Clear(list, i);
            }
            if(OperationEnum.ADDITION.getSymbol().equals(list.get(i))){
                return new Addition(list, i);
            }

            if(OperationEnum.SUBTRACTION.getSymbol().equals(list.get(i))){
                return new Subtraction(list, i);
            }

            if(OperationEnum.MULTIPLICATION.getSymbol().equals(list.get(i))){
                return new Multiplication(list, i);
            }
            if(OperationEnum.DIVISION.getSymbol().equals(list.get(i))){
                return new Division(list,i);
            }

            if(OperationEnum.SQRT.getSymbol().equals(list.get(i))){
                return new Sqrt(list, i);
            }
            if(OperationEnum.UNDO.getSymbol().equals(list.get(i))){
                return new Undo(list, i);
            }
        }
        return null;
    }
}
