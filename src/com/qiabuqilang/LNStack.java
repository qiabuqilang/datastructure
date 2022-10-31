package com.qiabuqilang;

import java.util.EmptyStackException;

public class LNStack {
    private ListNode headNode;
    private int top =-1;
    public LNStack(){
        this.headNode = new ListNode();
    }

    public void push(int data){
        top++;
        if(headNode == null){
            headNode = new ListNode(data);
        }else{
            ListNode listNode = new ListNode(data);
            listNode.setNext(headNode);
            headNode = listNode;

        }
    }
    public int top(){


        return top;
    }
    public int pop(){

        if (headNode == null){
            throw  new EmptyStackException();
        }else{
            top--;
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }

    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void deleteStack(){
        headNode = null;
    }

    public void printAll(){
        while(top()!= -1){
            System.out.println(pop());

        }
    }
}
