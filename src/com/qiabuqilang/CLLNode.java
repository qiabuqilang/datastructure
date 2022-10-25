package com.qiabuqilang;

public class CLLNode {
    private int data;
    private CLLNode next;
    public CLLNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }
    public int circularListLength(CLLNode headNode){
        int length = 0;
        CLLNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
            if(currentNode == headNode){
                break;
            }
        }
        return length;
    }

    public void printCircularListData(CLLNode headNode){
        CLLNode currentNode = headNode;
        while (currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
            if(currentNode == headNode){
                break;
            }
        }
        System.out.println("----------------------------");
    }



    public CLLNode insertAtEndInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null){
            headNode = nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    public CLLNode insertAtBeginInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null){
            headNode = nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
        return headNode;
    }

    public CLLNode deleteLastNodeFromCLL(CLLNode headNode){
        CLLNode temp = null;
        CLLNode currentNode = headNode;
        if(headNode == null){
            System.out.println("list empty");
            return null;
        }
        while(currentNode.getNext() != headNode){
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        temp.setNext(headNode);
        currentNode = null;
        return headNode;
    }

    public CLLNode deleteFirstNodeFromCLL(CLLNode headNode){
        CLLNode temp = headNode;
        CLLNode currentNode = headNode;
        if(headNode == null){
            System.out.println("list empty");
            return null;
        }
        while (currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(headNode.getNext());
        headNode = headNode.getNext();
        temp = null;
        return headNode;
    }
}
