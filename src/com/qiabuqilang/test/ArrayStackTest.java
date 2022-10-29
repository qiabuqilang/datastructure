package com.qiabuqilang.test;

import com.qiabuqilang.ArrayStack;

public class ArrayStackTest {
    public static void main(String[] args) {
        int len =5;
        ArrayStack arrayStack = new ArrayStack(len);
        for(int i=0;i<len;i++){
            arrayStack.push((int)(Math.random()*100));
        }
        arrayStack.printAll();
    }
}
