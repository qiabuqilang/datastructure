package com.qiabuqilang.test;

import com.qiabuqilang.CLLNode;

public class CLLNodeTest {
    public static void main(String[] args) {
        CLLNode[] cllNodes = new CLLNode[5];
        for(int i =0;i<5;i++){
            cllNodes[i] = new CLLNode(i+1);
        }
        for(int i =0;i<5;i++){
            if(i ==4){
                cllNodes[i].setNext(cllNodes[0]);
            }else{
                cllNodes[i].setNext(cllNodes[i+1]);
            }

        }
        CLLNode currentNode = cllNodes[0];
        CLLNode add8 = new CLLNode(8);
        CLLNode add9 = new CLLNode(9);
        // print original cllnodes
        currentNode.printCircularListData(currentNode);
        //test insert at begin
        currentNode = currentNode.insertAtBeginInCLL(currentNode,add8);
        currentNode.printCircularListData(currentNode);
        //test insert at last
        currentNode = currentNode.insertAtEndInCLL(currentNode,add9);
        currentNode.printCircularListData(currentNode);
        //test remove first
        currentNode = currentNode.deleteFirstNodeFromCLL(currentNode);
        currentNode.printCircularListData(currentNode);
        //test remove last
        currentNode = currentNode.deleteLastNodeFromCLL(currentNode);
        currentNode.printCircularListData(currentNode);
    }
}
