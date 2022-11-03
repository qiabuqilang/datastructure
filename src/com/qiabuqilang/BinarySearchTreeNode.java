package com.qiabuqilang;

public class BinarySearchTreeNode {
    private Integer data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
    //查找元素
    public BinarySearchTreeNode find(BinarySearchTreeNode root,int data){
        if(root == null){
            return null;
        }
        if(data < root.getData()){
            return find(root.getLeft(),data);
        }
        if(data > root.getData()){
            return find(root.getRight(),data);
        }
        return root;
    }
    //查找最小
    public BinarySearchTreeNode findMin(BinarySearchTreeNode root){
        if(root == null){
            return null;
        }else{
            if(root.getLeft() == null){
                return root;
            }else{
                return findMin(root.getLeft());
            }
        }

    }

    //查找最大
    public BinarySearchTreeNode findMax(BinarySearchTreeNode root){
        if(root == null){
            return null;
        }
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    //插入
    public BinarySearchTreeNode insert(BinarySearchTreeNode root,int data){
        if(root == null){
            root = new BinarySearchTreeNode();
            if(root == null){
                System.out.println("memory error");
                return null;
            }else{
                root.setData(data);
                root.setLeft(null);
                root.setRight(null);
            }

        }else{
            if(data<root.getData()){
                root.setLeft(insert(root.getLeft(),data));
            }else if(data >root.getData()){
                root.setRight(insert(root.getRight(),data));
            }
        }
        return root;
    }

    //删除
    public BinarySearchTreeNode delete(BinarySearchTreeNode root,int data){
        BinarySearchTreeNode temp;
        if(root == null){
            System.out.println("element not there in tree");
        }
        else if(data<root.getData()){
            root.left =  delete(root.getLeft(),data);
        }else if(data >root.getData()){
            root.right = delete(root.getRight(),data);
        }else{
            if(root.getLeft()!=null && root.getRight()!=null){
                temp = findMax(root.getLeft());
                root.setData(temp.getData());
                root.left = delete(root.getLeft(),root.getData());

            }else{
                temp = root;
                if(root.getLeft() == null){
                    root = root.getRight();
                }
                if(root.getRight() == null){
                    root = root.getLeft();
                }
            }
        }
        return root;
    }
}
