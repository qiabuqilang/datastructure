package com.qiabuqilang;

import java.util.EmptyStackException;

public class ArrayQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    public ArrayQueue(int size){
        capacity = size;
        front = -1;
        rear = -1;
        array = new int[size];
    }

    public static ArrayQueue createQueue(int size){
        return new ArrayQueue(size);
    }

    public boolean isEmpty(){
        return (front == -1);
    }

    public boolean isFull(){
        if(rear == -1 && front ==-1){
            return false;
        }
        if(rear == 0 && front ==0){
            return false;
        }
        return rear == front;
    }

    public int getQueueSize(int data){
        return (capacity-front+rear+1)%capacity;
    }

    public void enQueue(int data){
        if(isFull()){
            System.out.println("full");
            return;
        }else{
            rear = (rear+1)%capacity;
            array[rear] = data;
            if(front == -1){
                front = rear;
            }
        }

    }

    public int deQueue(){
        Integer data = null;
        if(isEmpty()){
            System.out.println("empty");
            return data;
        }else{
            data = array[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front = (front+1)%capacity;
            }
            return data;
        }

    }

    public void printAll(){
        while (isEmpty() !=true){
            System.out.println(deQueue());
        }
    }
}
