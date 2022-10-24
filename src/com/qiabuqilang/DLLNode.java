package com.qiabuqilang;

public class DLLNode {
    private int data;
    private DLLNode previous;
    private DLLNode next;
    public DLLNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public int listLength(DLLNode headNode){
        int length = 0;
        DLLNode currentNode = headNode;
        while (currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public DLLNode DLLInsert(DLLNode headNode,DLLNode nodeToInsert,int position){
        if(headNode == null){
            return nodeToInsert;
        }else{
            headNode = getHeadNode(headNode);
        }
        int size = listLength(headNode);
        if(position > size+1 || position< 1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+(size +1));
            return headNode;
        }
//        向头部插入
        if(position == 1){
            headNode.setPrevious(nodeToInsert);
            nodeToInsert.setPrevious(null);
            nodeToInsert.setNext(headNode);
            headNode = nodeToInsert;
        }else{
            //向非头部插入
            int count = 1;
            DLLNode previousNode = headNode;
            while(count < position -1){
                count++;
                previousNode = previousNode.getNext();
            }
            DLLNode currentNode = previousNode.getNext();
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
            nodeToInsert.setNext(currentNode);
            currentNode.setPrevious(nodeToInsert);
        }
        return headNode;
    }

    public DLLNode DLLDelete(DLLNode headNode,int position){
        headNode = getHeadNode(headNode);
        int size = listLength(headNode);
        if(position > size+1 || position< 1){
            System.out.println("Position of node to insert is invalid.The valid inputs are 1 to"+(size +1));
            return headNode;
        }
        if(position == 1){
            DLLNode nextNode = headNode.getNext();
            nextNode.setPrevious(null);
            headNode = nextNode;
        }else{
            int count = 1;
            DLLNode previousNode = headNode;
            while(count < position - 1){
                count++;
                previousNode = previousNode.getNext();
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode nextNode = currentNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
            currentNode = null;
        }
        return headNode;
    }

    public DLLNode getHeadNode(DLLNode currentNode){
        DLLNode headNode = currentNode;
        while (headNode.getPrevious() != null){
            headNode = headNode.getPrevious();
        }
        return headNode;
    }

    public void printDLLNode(DLLNode currentNode){
        //find 1st node
        DLLNode firstNode = getHeadNode(currentNode);
        //print all nodes
        while(firstNode.getNext() != null){
            System.out.println(firstNode.getData());
            firstNode = firstNode.getNext();
        }
    }
}
