public class SumOfNode {
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

    public static int sumNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumNode(root.leftTree);
        int rightSum = sumNode(root.rightTree);

        return leftSum + rightSum + root.data;

    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.leftTree = new Node(2);
        node.rightTree = new Node(3);
        node.leftTree.leftTree = new Node(4);
        node.leftTree.rightTree = new Node(5);
        node.rightTree.leftTree = new Node(6);
        node.rightTree.rightTree = new Node(7);

        System.out.println(sumNode(node));
    }
}
