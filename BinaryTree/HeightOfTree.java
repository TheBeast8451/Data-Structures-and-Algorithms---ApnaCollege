public class HeightOfTree {
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

    public static int heightTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heightTree(root.leftTree);
        int rh = heightTree(root.rightTree);
        int maxHeight = Math.max(lh, rh) + 1;
        return maxHeight;
    }

    public static void main(String[] args) {
/*
                    1
                 /     \
                2       3
              /   \   /   \
             4    5   6    7
*/

        Node node = new Node(1);
        node.leftTree = new Node(2);
        node.rightTree = new Node(3);
        node.leftTree.leftTree = new Node(4);
        node.leftTree.rightTree = new Node(5);
        node.rightTree.leftTree = new Node(6);
        node.rightTree.rightTree = new Node(7);

        System.out.println(heightTree(node)); 
    }
}
