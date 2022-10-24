package com.qiabuqilang;

public class Main {
    public static void printDLLNode(DLLNode headNode){
        DLLNode currentNode = headNode;
        while(currentNode.getNext() != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String[] args) {
	// write your code here
        DLLNode[] dllNodes = new DLLNode[5];
        for(int i =0;i<5;i++){
           dllNodes[i] = new DLLNode(i+1);
        }
        for(int i = 0;i<5;i++){
            if(i == 0){
                dllNodes[i].setPrevious(null);
                dllNodes[i].setNext(dllNodes[i+1]);
            }else if(i == 4){
                dllNodes[i].setNext(null);
                dllNodes[i].setPrevious(dllNodes[i-1]);
            }else{
                dllNodes[i].setPrevious(dllNodes[i-1]);
                dllNodes[i].setNext(dllNodes[i+1]);
            }
        }
        DLLNode currentNode = dllNodes[0];
        printDLLNode(dllNodes[0]);
    }


}
