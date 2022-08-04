package org.zxz.Tree.BalancedBinaryTree;

import org.zxz.Tree.BinarySearchTree.BinarySearchTree;

/**
 * @author LEGION
 */
public class BalancedBinaryTreeTest {
    public static void main(String[] args) {
        BalancedBinaryTree<Integer> balancedBinaryTree = new BalancedBinaryTree<Integer>();
        balancedBinaryTree.insert(22);
        balancedBinaryTree.insert(133);
        balancedBinaryTree.insert(111);
        balancedBinaryTree.insert(155);
        balancedBinaryTree.insert(122);
        balancedBinaryTree.insert(12);
        balancedBinaryTree.insert(9);
        balancedBinaryTree.insert(1);
        balancedBinaryTree.insert(18);
        balancedBinaryTree.insert(15);
        balancedBinaryTree.insert(20);
//        balancedBinaryTree.delete(12);
//        balancedBinaryTree.delete(22);
        System.out.println(balancedBinaryTree.getRoot().data);
        balancedBinaryTree.print();
    }
}
