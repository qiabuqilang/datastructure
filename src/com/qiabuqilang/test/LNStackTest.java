package com.qiabuqilang.test;

import com.qiabuqilang.LNStack;

public class LNStackTest {
    public static void main(String[] args) {
        int len = 5;
        LNStack lnStack = new LNStack();
        for(int i=0;i<len;i++){
            lnStack.push(i);
        }
        lnStack.printAll();
    }
}
