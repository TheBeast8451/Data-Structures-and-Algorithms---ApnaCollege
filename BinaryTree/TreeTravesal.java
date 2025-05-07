public class TreeTravesal {

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

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.leftTree);
            preOrder(root.rightTree);

        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.leftTree);
            System.out.print(root.data + " ");
            inOrder(root.rightTree);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.leftTree);
            postOrder(root.rightTree);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        int tree[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree demo = new BinaryTree();
        Node root = demo.buildTree(tree);
        // System.out.println(root.data);
        // demo.preOrder(root);
        // demo.inOrder(root);
        demo.postOrder(root);
    }

}
