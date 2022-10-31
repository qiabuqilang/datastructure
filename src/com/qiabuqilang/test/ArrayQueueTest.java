package com.qiabuqilang.test;

import com.qiabuqilang.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        int len = 5;
        for(int i=0;i<len;i++){

            arrayQueue.enQueue((int)(Math.random()*100));
        }
        arrayQueue.printAll();
    }
}
