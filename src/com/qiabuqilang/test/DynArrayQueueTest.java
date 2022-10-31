package com.qiabuqilang.test;

import com.qiabuqilang.DynArrayQueue;

public class DynArrayQueueTest {
    public static void main(String[] args) {
        DynArrayQueue dynArrayQueue = new DynArrayQueue();
        int len = 5;
        for(int i=0;i<len;i++){
            dynArrayQueue.enQueue(i+3);
        }
        dynArrayQueue.printAll();
    }
}
