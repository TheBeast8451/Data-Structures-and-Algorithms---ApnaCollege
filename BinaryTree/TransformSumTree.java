public class TransformSumTree {
    static class Node {
        int data;
        Node leftTree;
        Node rightTree;

        public Node(int data) {
            this.data = data;
            this.leftTree = null;
            this.rightTree = null;
        }
    }
    
    public static int printSumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftSub = printSumTree(root.leftTree);
        int rightSub = printSumTree(root.rightTree);

        int newLeft = root.leftTree == null ? 0 : root.leftTree.data;
        int newRight = root.rightTree == null ? 0 : root.rightTree.data;

        int data = root.data;
        root.data = newLeft + leftSub + newRight + rightSub;
        return data;

    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.leftTree);
        preOrder(root.rightTree);

    }

    public static void main(String[] args) {
/*
                 1 
              /    \
            2       3 
          /  \    /  \
         4    5  6    7 

         

                27 
              /    \
            9       13 
          /  \    /  \
         0    0  0    0 
         
         
*/

    Node node = new Node(1);
    node.leftTree = new Node(2);
    node.rightTree = new Node(3);
    node.leftTree.leftTree = new Node(4);
    node.leftTree.rightTree = new Node(5);
    node.rightTree.leftTree = new Node(6);
    node.rightTree.rightTree = new Node(7);

    printSumTree(node);
    preOrder(node);
    }
}
