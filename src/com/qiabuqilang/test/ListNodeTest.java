package com.qiabuqilang.test;

import com.qiabuqilang.ListNode;

public class ListNodeTest {
    public static void main(String[] args) {
        // create 5 listNode
        ListNode[] listNodes = new ListNode[5];
        for(int i = 0;i<5;i++){
            listNodes[i] = new ListNode(i+1);
        }
        // add next node
        for(int i = 0;i<5;i++){
            if(i == 4){
                listNodes[i].setNext(null);
            }else{
                listNodes[i].setNext(listNodes[i+1]);
            }
        }
        ListNode currentNode = listNodes[0];
        // print original linked list
        currentNode.printListNode(currentNode);
        // test add
        ListNode add7 = new ListNode(7);
        currentNode.inserInLinkedList(currentNode,add7,2);
        currentNode.printListNode(currentNode);
        // test remove
        currentNode.deleteNodeFromLinkedList(currentNode,3);
        currentNode.printListNode(currentNode);

        ListNode l1 = new ListNode();
        System.out.println(l1.getData());
    }
}
