package org.zxz.Tree.HuffmanTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LEGION
 */
public class HuffmanTree {
    private HuffmanTreeNode root;

    public HuffmanTree(int[] keys) {
        this.root = buildHuffmanTree(keys);
    }

    private HuffmanTreeNode buildHuffmanTree(int[] keys) {
        if (keys.length == 0) {
            return null;
        }
        PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<HuffmanTreeNode>();
        for (int key : keys) {
            queue.offer(new HuffmanTreeNode(key));
        }

        while (queue.size() > 1) {
            HuffmanTreeNode left = queue.poll();
            HuffmanTreeNode right = queue.poll();
            HuffmanTreeNode parent = new HuffmanTreeNode(left.getKey() + right.getKey(), left, right);
            left.setParent(parent);
            right.setParent(parent);
            queue.offer(parent);
        }
        return queue.poll();
    }

    public HuffmanTreeNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanTreeNode root) {
        this.root = root;
    }

    public void print() {
        print(root, 0);
    }

    private void print(HuffmanTreeNode node, int level) {
        if (node == null) {
            return;
        }
        print(node.getRight(), level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getKey());
        print(node.getLeft(), level + 1);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(HuffmanTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getKey() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(HuffmanTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        inOrder(node.getRight());
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(HuffmanTreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getKey() + " ");
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(HuffmanTreeNode node) {
        if (node == null) {
            return;
        }
        PriorityQueue<HuffmanTreeNode> queue = new PriorityQueue<HuffmanTreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            HuffmanTreeNode cur = queue.poll();
            System.out.print(cur.getKey() + " ");
            if (cur.getLeft() != null) {
                queue.offer(cur.getLeft());
            }
            if (cur.getRight() != null) {
                queue.offer(cur.getRight());
            }
        }
    }
}
