package com.karl.calculator;

import com.karl.calculator.base.OperationFactory;
import com.karl.calculator.operator.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by karl on 2018/11/19.
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator calculator  = new Calculator();
        Scanner sc = new Scanner(System.in);
        String ret = "";
        while(sc.hasNext()) {
            String n = ret + sc.nextLine();
            ret = calculator.calculator(n);
        }
    }

    public String calculator(String str){
        List<String> list = new ArrayList<String>(Arrays.asList(str.split(" ")));
        Operation operation = OperationFactory.findFirstOperation(list) ;
        while (operation != null) {
            if (operation.operation()) {
                break;
            }
            operation = OperationFactory.findFirstOperation(list) ;
        }
        String ret = getFormatRet(list);
        printList(list);

        return ret;
    }

    private void printList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            if(Character.isDigit(str.charAt(0)) && new BigDecimal(str).precision() > 10) {
                if(str.contains(".")) {
                    str = str.substring(0, 11);
                }
            }
            sb.append(str).append(" ");

        }
        System.out.println("stack: " + sb.toString());
    }

    private String getFormatRet(List<String> list) {
        if(list == null || list.size() <=0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str).append(" ");
        }
        return sb.toString();
    }
}
