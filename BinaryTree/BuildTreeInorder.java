public class BuildTreeInorder {
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
    }

    public static void main(String[] args) {
        int tree[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree demo = new BinaryTree();
        Node root = demo.buildTree(tree);
        System.out.println(root.data);
    }
}