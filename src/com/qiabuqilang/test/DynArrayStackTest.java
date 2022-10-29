package com.qiabuqilang.test;

import com.qiabuqilang.DynArrayStack;

public class DynArrayStackTest {
    public static void main(String[] args) {
        int len = 5;
        DynArrayStack dynArrayStack = new DynArrayStack();
        for(int i=0;i<len;i++){
            dynArrayStack.push((int)(Math.random()*100));
        }
        dynArrayStack.printAll();
    }
}
