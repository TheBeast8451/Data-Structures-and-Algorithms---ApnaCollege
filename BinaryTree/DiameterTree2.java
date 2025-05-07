public class DiameterTree2 {
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

    static class Info{
        int diam;
        int height;
        Info(int diam,int height){
            this.diam=diam;
            this.height=height;
        }
    }

    public static Info findDiamater(Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo= findDiamater(root.leftTree);
        Info rightInfo = findDiamater(root.rightTree);

        int height = Math.max(leftInfo.height ,rightInfo.height)+1;
        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height+rightInfo.height+1);
        return new Info(diameter, height);
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
        System.out.println(findDiamater(node).diam);
    }
}
