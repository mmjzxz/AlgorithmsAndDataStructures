package org.zxz.Tree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LEGION
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> root;

    public class BinarySearchTreeNode<T extends Comparable<T>> {
        T data;
        BinarySearchTreeNode<T> left;
        BinarySearchTreeNode<T> right;
        BinarySearchTreeNode<T> parent;

        public BinarySearchTreeNode(T data, BinarySearchTreeNode<T> left,
                                    BinarySearchTreeNode<T> right,
                                    BinarySearchTreeNode<T> parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T data) {
        root = new BinarySearchTreeNode<T>(data, null, null, null);
    }

    public BinarySearchTree(T data, BinarySearchTreeNode<T> left,
                            BinarySearchTreeNode<T> right,
                            BinarySearchTreeNode<T> parent) {
        root = new BinarySearchTreeNode<T>(data, left, right, parent);
    }

    public BinarySearchTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    /**
     * @param data
     * @return
     */
    public void insert(T data) {
        if (root == null) {
            root = new BinarySearchTreeNode<T>(data, null, null, null);
        } else {
            insert(root, data);
        }
    }

    /**
     * @param node
     * @param data
     * @return
     */
    public void insert(BinarySearchTreeNode<T> node, T data) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new BinarySearchTreeNode<T>(data, null, null, node);
            } else {
                insert(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new BinarySearchTreeNode<T>(data, null, null, node);
            } else {
                insert(node.right, data);
            }
        }
    }

    /**
     * @param data
     * @return
     */
    public void delete(T data) {
        if (root == null) {
            return;
        }
        delete(root, data);
    }


    /**
     * @param node
     * @param data
     * @return
     */
    public void delete(BinarySearchTreeNode<T> node, T data) {
        if (node == null) {
            return;
        }

        if (data.compareTo(node.data) < 0) {
            delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            delete(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            } else if (node.left == null) {
                if (node.parent.left == node) {
                    node.parent.left = node.right;
                } else {
                    node.parent.right = node.right;
                }
            } else if (node.right == null) {
                if (node.parent.left == node) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                }
            } else {
                BinarySearchTreeNode<T> successor = getSuccessor(node);
                node.data = successor.data;
                delete(successor, successor.data);
            }
        }
    }

    /**
     * @param node
     * @return
     */
    private BinarySearchTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }


    /**
     * ????????????
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * ????????????
     *
     * @param node
     */
    public void preOrder(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * ????????????
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * ????????????
     *
     * @param node
     */
    public void inOrder(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * ????????????
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * ????????????
     *
     * @param node
     */
    public void postOrder(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * ????????????
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        levelOrder(root);
    }

    /**
     * ????????????
     *
     * @param node
     */
    public void levelOrder(BinarySearchTreeNode<T> node) {
        Queue<BinarySearchTreeNode<T>> queue = new LinkedList<BinarySearchTreeNode<T>>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            BinarySearchTreeNode<T> temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * ??????????????????
     *
     * @return
     */
    public BinarySearchTreeNode<T> search(T data) {
        return search(root, data);
    }

    /**
     * ??????????????????
     *
     * @param node
     * @param data
     * @return
     */
    public BinarySearchTreeNode<T> search(BinarySearchTreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            return search(node.right, data);
        } else {
            return node;
        }
    }

    /**
     * ?????????????????????
     *
     * @param data
     * @return
     */

    public BinarySearchTreeNode<T> iterativeSearch(T data) {
        return iterativeSearch(root, data);
    }

    /**
     * ?????????????????????
     *
     * @param node
     * @param data
     * @return
     */
    public BinarySearchTreeNode<T> iterativeSearch(BinarySearchTreeNode<T> node, T data) {
        while (node != null) {
            if (data.compareTo(node.data) < 0) {
                node = node.left;
            } else if (data.compareTo(node.data) > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * ???????????????
     *
     * @return
     */
    public BinarySearchTreeNode<T> getMin() {
        return getMin(root);
    }

    /**
     * ???????????????
     *
     * @param node
     * @return
     */
    public BinarySearchTreeNode<T> getMin(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    /**
     * ???????????????
     *
     * @return
     */
    public BinarySearchTreeNode<T> getMax() {
        return getMax(root);
    }

    /**
     * ???????????????
     *
     * @param node
     * @return
     */
    public BinarySearchTreeNode<T> getMax(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * ??????????????????
     *
     * @param data
     * @return
     */
    public BinarySearchTreeNode<T> predecessor(T data) {
        BinarySearchTreeNode<T> node = search(data);
        return predecessor(node);
    }

    /**
     * ??????????????????
     *
     * @param node
     * @return
     */
    public BinarySearchTreeNode<T> predecessor(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return getMax(node.left);
        }
        BinarySearchTreeNode<T> parent = node.parent;
        while (parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * ??????????????????
     *
     * @param data
     * @return
     */
    public BinarySearchTreeNode<T> successor(T data) {
        BinarySearchTreeNode<T> node = search(data);
        return successor(node);
    }

    /**
     * ??????????????????
     *
     * @param node
     * @return
     */
    public BinarySearchTreeNode<T> successor(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getMin(node.right);
        }
        BinarySearchTreeNode<T> parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /**
     * ?????????????????????
     *
     * @return
     */
    public void clear() {
        destroy(root);
        root = null;
    }

    /**
     * ?????????????????????
     *
     * @param node
     */
    private void destroy(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }
        destroy(node.left);
        destroy(node.right);
        node = null;
    }

    /**
     * ??????????????????/??????
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * ??????????????????/??????
     *
     * @param node
     * @return
     */
    private int height(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * ?????????????????????
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * ?????????????????????
     *
     * @param node
     * @return
     */
    private int size(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }
}
