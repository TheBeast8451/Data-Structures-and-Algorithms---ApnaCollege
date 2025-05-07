public class DiameterTree {
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

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.leftTree);
        int rightHeight = height(root.rightTree);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static int findDiamater(Node root) {
        if(root == null){
            return 0;
        }
        int leftDia = findDiamater(root.leftTree);
        int leftHt = height(root.leftTree);

        int rightDia = findDiamater(root.rightTree);
        int rightHt = height(root.rightTree);    
        
        int selfDia = leftHt+rightHt+1;
        return Math.max(selfDia,Math.max(leftDia, rightDia));
    }

    public static void main(String[] args) {
        /*
         *     1
         *    / \
         *   2   3
         *  / \ / \
         * 4  5 6  7
         * 
         */

        Node node = new Node(1);
        node.leftTree = new Node(2);
        node.rightTree = new Node(3);
        node.leftTree.leftTree = new Node(4);
        node.leftTree.rightTree = new Node(5);
        node.rightTree.leftTree = new Node(6);
        node.rightTree.rightTree = new Node(7);

        System.out.println(findDiamater(node));
    }
}
