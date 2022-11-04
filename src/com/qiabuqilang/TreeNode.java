package com.qiabuqilang;

public class TreeNode {
    public int data;
    public TreeNode firstNode;
    public TreeNode nextSibling;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(TreeNode firstNode) {
        this.firstNode = firstNode;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }

    //计算所有节点之和
    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.getData() + findSum(root.getFirstNode()) + findSum(root.getNextSibling());
    }
}
