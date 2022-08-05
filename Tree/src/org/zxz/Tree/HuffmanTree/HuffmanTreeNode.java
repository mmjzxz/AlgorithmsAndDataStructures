package org.zxz.Tree.HuffmanTree;

public class HuffmanTreeNode implements Comparable, Cloneable {
    private int key;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;
    private HuffmanTreeNode parent;

    public HuffmanTreeNode(int key) {
        this.key = key;
    }

    public HuffmanTreeNode(int key, HuffmanTreeNode left, HuffmanTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public HuffmanTreeNode(int key, HuffmanTreeNode left, HuffmanTreeNode right, HuffmanTreeNode parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }


    @Override
    public int compareTo(Object o) {
        return this.key - ((HuffmanTreeNode) o).key;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public HuffmanTreeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanTreeNode left) {
        this.left = left;
    }

    public HuffmanTreeNode getRight() {
        return right;
    }

    public void setRight(HuffmanTreeNode right) {
        this.right = right;
    }

    public HuffmanTreeNode getParent() {
        return parent;
    }

    public void setParent(HuffmanTreeNode parent) {
        this.parent = parent;
    }
}
