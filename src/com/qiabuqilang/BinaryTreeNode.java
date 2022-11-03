package com.qiabuqilang;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    //非递归前序遍历
    public void preOrderNonRecursive(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }
            root = (BinaryTreeNode) stack.pop();
            root = root.getRight();
        }
        return;
    }
    //中序遍历
    public void inOrder(BinaryTreeNode root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }
    //非递归中序遍历
    public void inOrderNonRecursive(BinaryTreeNode root){
        if(root == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }
            root = (BinaryTreeNode) stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
        return;
    }
    //后序遍历
    public void postOrder(BinaryTreeNode root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
    //非递归后续遍历
    public void postOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true){
            if(root != null){
                stack.push(root);
                root = root.getLeft();
            }else{
                if(stack.isEmpty()){
                    System.out.println("stack is empty");
                    return;
                }else{
                    if(stack.peek().getRight() == null){
                        root = stack.pop();
                        System.out.println(root.getData());

                    }
                    if(!stack.isEmpty()){
                        root = stack.peek().getRight();
                        root = null;
                    }
                }

            };
        }
    }

    //层次遍历
    public void levelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            System.out.println(temp.getData());
            if(temp.getLeft() !=null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
        }

    }

    //查找二叉树最大
    public int findMax(BinaryTreeNode root){
        int root_val,left,right,max = Integer.MIN_VALUE;
        if(root != null){
            root_val = root.getData();
            left = findMax(root.getLeft());
            right = findMax(root.getRight());
            if(left>right){
                max = left;
            }else{
                max = right;
            }
            if(root_val>max){
                max = root_val;
            }
        }
        return max;
    }

    //层次遍历获取最大
    public int findMaxUsingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if(max < temp.getData()){
                max = temp.getData();
            }
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
        }
        return max;
    }

    //搜索元素
    public Boolean findInBinaryTreeUsingRecursion(BinaryTreeNode root,int data){
        Boolean temp;
        if(root == null){
            return false;
        }else{
            if(data == root.getData()){
                return true;
            }else{
                temp = findInBinaryTreeUsingRecursion(root.getLeft(),data);
                if(temp != true){
                    return temp;
                }else{
                    return findInBinaryTreeUsingRecursion(root.getRight(),data);
                }
            }
        }

    }

    //层次遍历搜索元素
    public Boolean searchUsingLevelOrder(BinaryTreeNode root,int data11){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root == null){
            return false;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if(data == root.getData()){
                return true;
            }
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }

        }
        return false;
    }

    //插入二叉树
    public void insertInBinaryTree(BinaryTreeNode root,int data){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode temp;
        BinaryTreeNode newTree = new BinaryTreeNode();
        newTree.setLeft(null);
        newTree.setRight(null);
        if(newTree == null){
            System.out.println("memery error");
            return;
        }
        if(root == null){
            root = newTree;
            return;
        }
        queue.add(newTree);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if(temp.getLeft() !=null){
                queue.add(temp.getLeft());
            }else{
                temp.setLeft(newTree);
                queue = null;
                return;
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }else{
                temp.setRight(newTree);
                queue = null;
                return;
            }
        }
    }

    //获取节点个数
    public int sizeOfBinaryTree(BinaryTreeNode root){
        if(root == null){
            return 0;

        }else{
            return (sizeOfBinaryTree(root.getLeft())+1+sizeOfBinaryTree(root.getRight()));
        }

    }

    //层次遍历获取节点个数
    public int sizeOfBinaryTreeLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root == null){
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            count++;
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }

        }
        return count;
    }

    //删除节点
    public void deleteBinaryTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        deleteBinaryTree(root.getLeft());
        deleteBinaryTree(root.getRight());
        root = null;
    }

    //逆向输出
    public void levelOrderTraversalInReverse(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode temp = null;
        if(root == null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());

            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().getData());
        }

    }

    //计算高度
    public int heightOfBinaryTree(BinaryTreeNode root){
        int leftHeight,rightHeight;
        if(root == null){
            return 0;
        }else{
            leftHeight = heightOfBinaryTree(root.getLeft());
            rightHeight =  heightOfBinaryTree(root.getRight());
            if(leftHeight>rightHeight){
                return leftHeight+1;
            }else{
                return rightHeight+1;
            }
        }

    }

    //层次遍历计算高度
    public int findHeightOfBinaryTree(BinaryTreeNode root){
        int level = 1;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            root = queue.remove();
            if(root ==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                level++;
            }else{
                if(root.getLeft() !=null){
                    queue.add(root.getLeft());
                }
                if(root.getRight()!= null){
                    queue.add(root.getRight());
                }
            }

        }
        return level;
    }

    //查找最深节点
    public BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root){
        BinaryTreeNode temp = null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root == null){
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.remove();
            if(temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.add(temp.getRight());
            }
        }
        return temp;
    }
}
