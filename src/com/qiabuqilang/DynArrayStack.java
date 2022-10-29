package com.qiabuqilang;

import java.util.EmptyStackException;

public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public DynArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isStackFull(){
        return top == capacity -1;
    }
    public void push(int data){
        if(isStackFull()){
            System.out.println("stack full");
            return;
        }
        doubleStack();
        array[++top] = data;
        System.out.println("top:"+top+"---data:"+data);

    }
    public int pop(){
        if(isEmpty()){
            System.out.println("stack empty");
            throw new EmptyStackException();
        }else{
            return array[top--];
        }

    }
    private void doubleStack(){
        int[] newArray = new int[capacity*2];
        System.arraycopy(array,0,newArray,0,capacity);
        capacity = capacity*2;
        array = newArray;
    }
    public void printAll(){
        while(top != -1){
            System.out.println(pop());
        }
    }
}
