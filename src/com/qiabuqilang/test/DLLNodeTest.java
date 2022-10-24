package com.qiabuqilang.test;

import com.qiabuqilang.DLLNode;

public class DLLNodeTest {


    public static void main(String[] args) {
        DLLNode[] dllNodes = new DLLNode[5];
        for(int i =0;i<5;i++){
            dllNodes[i] = new DLLNode(i+1);
        }
        for(int i = 0;i<5;i++){
            if(i == 0){
                dllNodes[i].setPrevious(null);
                dllNodes[i].setNext(dllNodes[i+1]);
            }else if(i == 4){
                dllNodes[i].setNext(null);
                dllNodes[i].setPrevious(dllNodes[i-1]);
            }else{
                dllNodes[i].setPrevious(dllNodes[i-1]);
                dllNodes[i].setNext(dllNodes[i+1]);
            }
        }
        DLLNode currentNode = dllNodes[2];
        currentNode.printDLLNode(currentNode);
        System.out.println("------------------------");
        // test add
        DLLNode insert7 = new DLLNode(7);
        currentNode.DLLInsert(currentNode,insert7,3);
        currentNode.printDLLNode(currentNode);
        System.out.println("------------------------");
        // test remove
        currentNode.DLLDelete(currentNode,2);
        currentNode.printDLLNode(currentNode);
        System.out.println("------------------------");
    }
}
