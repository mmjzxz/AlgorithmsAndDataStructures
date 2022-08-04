package org.zxz.Tree.BinarySearchTree;

/**
 * @author LEGION
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(6);
        binarySearchTree.insert(20);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(17);
        binarySearchTree.insert(13);
        binarySearchTree.insert(18);
        binarySearchTree.insert(19);
        binarySearchTree.insert(16);
        binarySearchTree.insert(14);
        binarySearchTree.insert(12);
        binarySearchTree.insert(11);
        binarySearchTree.insert(9);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
//        binarySearchTree.inOrder();
//        binarySearchTree.delete(15);
        BinarySearchTree<Integer>.BinarySearchTreeNode<Integer> search = binarySearchTree.search(15);
        binarySearchTree.inOrder(search);
    }
}
