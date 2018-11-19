package com.karl.calculator.operator;

import com.karl.calculator.base.IndexValue;
import com.karl.calculator.base.OperationEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karl on 2018/11/19.
 */
public abstract class Operation{
    public List<String> express;
    private OperationEnum symbol;
    public List<String> params;

    public List<String> getExpress() {
        return express;
    }

    public OperationEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(OperationEnum symbol) {
        this.symbol = symbol;
    }

    public void setExpress(List<String> express) {
        this.express = express;
    }

    public List<String> getParams() {
        if(params== null){
            params = new ArrayList<String>();
        }
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    private IndexValue indexValue;

    public abstract void calculate();

    public boolean operation(){
        if(invalidate()){
            System.out.println("operator " + this.getSymbol().getSymbol()+" (position: " + getPosition()+"): insucient parameter");
            return true;
        }
        calculate();
        return false;
    }

    private int getPosition() {
        int count = 0;
        for(String str: this.getExpress()) {
            count +=str.length();
            count++;
        }
        count--;
        return count;
    }

    protected abstract boolean invalidate();

    public Operation setIndexValue(IndexValue iv){
        this.indexValue = iv;
        return this;
    }
    protected IndexValue getIndexValue() {
        return indexValue;
    }

}
