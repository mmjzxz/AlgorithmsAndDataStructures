package org.zxz.Tree.HuffmanTree;

/**
 * @author LEGION
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] keys = {10, 20, 30, 40};
        HuffmanTree huffmanTree = new HuffmanTree(keys);
        huffmanTree.print();
    }
}
