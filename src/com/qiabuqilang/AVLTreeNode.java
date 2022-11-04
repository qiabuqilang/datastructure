package com.qiabuqilang;

public class AVLTreeNode {
    private int data;
    private int height;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }

    public int height(AVLTreeNode root){
        if(root == null){
            return -1;
        }else{
            return root.getHeight();
        }
    }
    //左旋
    public AVLTreeNode singleRotateLeft(AVLTreeNode x){
        AVLTreeNode w = x.getLeft();
        x.setLeft(w.getRight());
        w.setRight(x);
        x.setHeight(Math.max(height(x.left),height(x.getRight())+1));
        w.setHeight(Math.max(height(w.left),x.height+1));
        return w;
    }
    //右旋
    public AVLTreeNode singleRotateRight(AVLTreeNode w){
        AVLTreeNode x = w.getRight();
        w.setRight(x.getLeft());
        x.setLeft(w);
        w.setHeight(Math.max(height(w.getRight()),height(w.getLeft())+1));
        x.setHeight(Math.max(height(x.getRight()),w.height+1));
        return x;
    }

    public AVLTreeNode doubleRotateWithLeft(AVLTreeNode z){
        z.setLeft(singleRotateRight(z.getLeft()));
        return singleRotateLeft(z);
    }
    //插入
    public AVLTreeNode insert(AVLTreeNode root,AVLTreeNode parent,int data){
        if(root == null){
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }else if(data < root.getData()){
            root.setLeft(insert(root.getLeft(),root,data));
            if(height(root.getLeft())-height(root.getRight()) == 2){
                if(data < root.getLeft().getData()){
                    root = singleRotateLeft(root);
                }else{
                    root = doubleRotateWithLeft(root);
                }
            }
        }else if(data >root.getData()){
            root.setRight(insert(root.getRight(),root,data));
            if(height(root.getRight())-height(root.getLeft())==2){
                if(data < root.getRight().getData()){
                    root = singleRotateRight(root);
                }else{
                    root = singleRotateLeft(root);
                }
            }
        }
        root.setHeight(Math.max(height(root.getLeft()),height(root.getRight())+1));
        return root;
    }
}
