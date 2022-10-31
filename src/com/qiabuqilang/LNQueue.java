package com.qiabuqilang;

public class LNQueue {
   private ListNode front =null;
   private ListNode rear = null;
   public LNQueue(){
       this.front = null;
       this.rear = null;
   }

   public static LNQueue createQueue(){
       return new LNQueue();
   }

   public boolean isEmpty(){
       return front == null;
   }

   public void enQueue(int data){
       ListNode node = new ListNode(data);
       if(rear != null){
           rear.setNext(node);
       }
       rear = node;
       if(front == null){
           front = rear;
       }
   }

   public Integer deQueue(){
       Integer data = null;
       if(isEmpty()){
           System.out.println("empty");
       }else{
           data = front.getData();
           front = front.getNext();
       }
        return data;
   }

   public void printAll(){
       while (isEmpty() != true){
           System.out.println(deQueue());

       }
   }
}
