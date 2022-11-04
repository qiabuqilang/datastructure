package com.qiabuqilang;

import java.util.LinkedList;

public class Heap {
    private int[] array;
    private int count;
    private int capacity;
    private int heap_type;

    public Heap(int capacity,int heap_type){
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int parent(int i){
        if(i<=0 || i>=this.count){
            return -1;
        }
        return (i-1)/2;
    }

    public int leftChild(int i){
        int left = 2*i+1;
        if(left>=this.count){
            return -1;
        }
        return left;
    }

    public int rightChild(int i){
        int right = 2*i+2;
        if(right>this.count){
            return -1;
        }
        return right;
    }

    public int getMax(){
        if(this.count ==0){
            return -1;
        }
        return this.array[0];
    }

    //向下渗透，插入堆化
    public void percolateDown(int i){
        int left,right,max,temp;
        left = leftChild(i);
        right = rightChild(i);
        if(left != -1 && this.array[left]>array[i]){
            max = left;
        }else{
            max = i;
        }
        if(right != -1 && this.array[right]>array[i]){
            max = right;
        }
        if(max != i){
            temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
        }
        percolateDown(max);

    }

    //删除
    public int deleteMax(){
        if(this.count == 0){
            return -1;
        }
        int data = this.array[0];
        this.array[0] = this.array[this.count-1];
        this.count--;
        percolateDown(0);
        return data;
    }

    //插入
    public void insert(int data){
        int i=0;
        if(this.count == this.capacity){
            resizeHeap();
        }
        this.count++;
        while(i>=0 && data > this.array[(i-1)/2]){
            this.array[i] = this.array[(i-1)/2];
            i = (i-1)/2;
        }
        this.array[i] = data;
    }

    //扩充
    public void resizeHeap(){
        int[] array_old = new int[this.capacity];
        System.arraycopy(this.array,0,array_old,0,this.count-1);
        this.array = new int[this.capacity*2];
        if(this.array == null){
            System.out.println("memory error");
            return;
        }
        for(int i=0;i<this.capacity;i++){
            this.array[i] = array_old[i];
            this.capacity *=2;
            array_old = null;
        }

    }

    //清空
    public void destroyHeap(){
        this.count =0;
        this.array = null;
    }
}
