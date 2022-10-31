package com.qiabuqilang.test;

import com.qiabuqilang.LNQueue;

public class LNQueueTest {
    public static void main(String[] args) {
        int len = 5;
        LNQueue lnQueue = new LNQueue();
        for(int i=0;i<len;i++){
            lnQueue.enQueue(i+3);
        }
        lnQueue.printAll();
    }
}
