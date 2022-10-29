package com.qiabuqilang;

import java.util.EmptyStackException;

public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public ArrayStack(int capa) {
        capacity = capa;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return (top == capacity - 1);
    }

    public void push(int data) {
        if (isStackFull()) {
            System.out.println("stack overflow");

        } else {
            array[++top] = data;
            System.out.println("top:"+top+"---data:"+data);
        }

    }

    public int pop() {
        if (isEmpty()) {
           throw new EmptyStackException();
        } else {
            return array[top--];
        }
    }

    public void deleteStack(){
        top = -1;
    }

    public void printAll(){
        while(top != -1){
            System.out.println(pop());
        }
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
