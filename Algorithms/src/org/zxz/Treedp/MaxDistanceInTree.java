package org.zxz.Treedp;

/**
 * @author LEGION
 */
public class MaxDistanceInTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        System.out.println(maxDistance(root));
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node root) {
        return process(root).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int dis, int h) {
            maxDistance = dis;
            height = h;
        }
    }

    public static Info process(Node node) {
        if (node == null) {
            return new Info(0, 0);
        }
        Info left = process(node.left);
        Info right = process(node.right);
        int leftMaxDistance = left.maxDistance;
        int rightMaxDistance = right.maxDistance;
        int maxDistanceIncludeNode = left.height + right.height + 1;
        int maxDistance = Math.max(Math.max(leftMaxDistance, rightMaxDistance), maxDistanceIncludeNode);
        int height = Math.max(left.height, right.height) + 1;
        return new Info(maxDistance, height);
    }
}
