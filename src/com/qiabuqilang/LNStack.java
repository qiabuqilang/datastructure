package com.qiabuqilang;

import java.util.EmptyStackException;

public class LNStack {
    private ListNode headNode;
    public LNStack(){
        this.headNode = new ListNode();
    }

    public void push(int data){
        if(headNode == null){
            headNode = new ListNode(data);
        }else{
            ListNode listNode = new ListNode(data);
            listNode.setNext(headNode);
            headNode = listNode;

        }
    }
    public int top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return headNode.getData();
    }
    public int pop(){
        if (headNode == null){
            throw  new EmptyStackException();
        }else{
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }

    }
    public boolean isEmpty(){
        if(headNode ==null){
            return true;
        }else {
            return false;
        }
    }

    public void deleteStack(){
        headNode = null;
    }
}
