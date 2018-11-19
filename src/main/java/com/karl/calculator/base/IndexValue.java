package com.karl.calculator.base;

/**
 * Created by karl on 2018/11/19.
 */
public class IndexValue {
    private int index;
    private String value;

    public IndexValue(int index, String value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
