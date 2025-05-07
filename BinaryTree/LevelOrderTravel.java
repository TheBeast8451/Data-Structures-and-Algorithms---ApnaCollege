
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTravel {
    static class Node {
        int data;
        Node leftTree;
        Node rightTree;

        Node(int data) {
            this.data = data;
            this.leftTree = null;
            this.rightTree = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int tree[]) {
            idx++;
            if (tree[idx] == -1) {
                return null;
            }
            Node newNode = new Node(tree[idx]);
            newNode.leftTree = buildTree(tree);
            newNode.rightTree = buildTree(tree);
            return newNode;
        }

        public static void levelOrderTree(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.leftTree != null) {
                        q.add(currNode.leftTree);
                    }
                    if (currNode.rightTree != null) {
                        q.add(currNode.rightTree);
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        int tree[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree demo = new BinaryTree();
        Node root = demo.buildTree(tree);
        demo.levelOrderTree(root);
    }
}