public class MinimumDistanceBtNode {
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

    public static Node findLCANode(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = findLCANode(root.leftTree, n1,n2);
        Node rightLca = findLCANode(root.rightTree, n1,n2);

        if(leftLca == null){
            return rightLca;
        }

        if(rightLca == null){
            return leftLca;
        }

        return root;
    }

    public static int lcaDis(Node root,int n){
        if(root == null){
            return -1;
        }

        // Overlap node loop
        if(root.data == n){
            return 0;
        }

        int leftDis = lcaDis(root.leftTree, n);
        int rightDis = lcaDis(root.rightTree, n);

        if(leftDis == -1 && rightDis == -1){
            return -1;
        } else if(leftDis == -1){
            return rightDis+1;
        } else{
            return leftDis+1;
        }
    }
    public static int findMinDistance(Node root,int n1,int n2){
        Node lca = findLCANode(root,n1,n2); 
        int leftSum = lcaDis(lca, n1);
        int rightSum = lcaDis(lca, n2);
        return leftSum+rightSum;
    }


    public static void main(String[] args) {
/*
                 1 
              /    \
            2       3 
          /  \    /  \
         4    5  6    7 
         
         
*/

        Node node = new Node(1);
        node.leftTree = new Node(2);
        node.rightTree = new Node(3);
        node.leftTree.leftTree = new Node(4);
        node.leftTree.rightTree = new Node(5);
        node.rightTree.leftTree = new Node(6);
        node.rightTree.rightTree = new Node(7);

        System.out.println(findMinDistance(node, 4, 6));
    }
}
