package org.zxz.Tree.BalancedBinaryTree;

/**
 * @author LEGION
 */
public class BalancedBinaryTree<T extends Comparable<T>> {
    private BalancedBinaryTreeNode<T> root;

    public class BalancedBinaryTreeNode<T extends Comparable<T>> {
        T data;
        BalancedBinaryTreeNode<T> left;
        BalancedBinaryTreeNode<T> right;
        int height;

        public BalancedBinaryTreeNode(T data) {
            this.data = data;
            this.height = 0;
        }

        public BalancedBinaryTreeNode(T data,
                                      BalancedBinaryTreeNode<T> left,
                                      BalancedBinaryTreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    public BalancedBinaryTree() {
        this.root = null;
    }

    public BalancedBinaryTree(T data) {
        this.root = new BalancedBinaryTreeNode<T>(data);
    }

    public BalancedBinaryTree(T data,
                              BalancedBinaryTree<T> left,
                              BalancedBinaryTree<T> right) {
        this.root = new BalancedBinaryTreeNode<T>(data, left.root, right.root);
    }

    public BalancedBinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BalancedBinaryTreeNode<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new BalancedBinaryTreeNode<T>(data);
        } else {
            insert(root, data);
        }
    }

    private BalancedBinaryTreeNode<T> insert(BalancedBinaryTreeNode<T> node,
                                             T data) {
        if (node == null) {
            return new BalancedBinaryTreeNode<T>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return balance(node);
    }

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public BalancedBinaryTreeNode<T> delete(T data) {
        if (root == null) {
            return null;
        }
        return delete(root, data);
    }

    private BalancedBinaryTreeNode<T> delete(BalancedBinaryTreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                BalancedBinaryTreeNode<T> min = getMin(node.right);
                node.data = min.data;
                node.right = delete(node.right, min.data);
            }
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return balance(node);
    }

    private BalancedBinaryTreeNode<T> getMin(BalancedBinaryTreeNode<T> right) {
        if (right.left == null) {
            return right;
        }
        return getMin(right.left);
    }

    /**
     * 平衡二叉树
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> balance(BalancedBinaryTreeNode<T> node) {
        if (getBalance(node) > 1) {
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        } else if (getBalance(node) < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    /**
     * 左旋转
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> rotateLeft(BalancedBinaryTreeNode<T> node) {
        BalancedBinaryTreeNode<T> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    /**
     * 右旋转
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> rotateRight(BalancedBinaryTreeNode<T> node) {
        BalancedBinaryTreeNode<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
        return temp;
    }

    private int getBalance(BalancedBinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 获取树的高度
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BalancedBinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * LL型：左左
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> leftLeftRotation(BalancedBinaryTreeNode<T> node) {
        BalancedBinaryTreeNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        left.height = Math.max(getHeight(left.left), node.height) + 1;
        return left;
    }

    /**
     * RR型：右右
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> rightRightRotation(BalancedBinaryTreeNode<T> node) {
        BalancedBinaryTreeNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        right.height = Math.max(getHeight(right.right), node.height) + 1;
        return right;
    }

    /**
     * LR型：左右
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> leftRightRotation(BalancedBinaryTreeNode<T> node) {
        node.left = rightRightRotation(node.left);
        return leftLeftRotation(node);
    }

    /**
     * RL型：右左
     *
     * @param node
     * @return
     */
    private BalancedBinaryTreeNode<T> rightLeftRotation(BalancedBinaryTreeNode<T> node) {
        node.right = leftLeftRotation(node.right);
        return rightRightRotation(node);
    }

    public void print() {
        print(root);
    }

    private void print(BalancedBinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }
}
