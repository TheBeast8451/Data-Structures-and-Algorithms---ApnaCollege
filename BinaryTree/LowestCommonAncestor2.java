public class LowestCommonAncestor2 {
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
    public static Node findLCATreeNode(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = findLCATreeNode(root.leftTree, n1, n2);
        Node rightLca = findLCATreeNode(root.rightTree, n1, n2);

        if(rightLca == null){
           return leftLca;
        } 

        if(leftLca == null){
           return rightLca;
        }

        return root;
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
        System.out.println(findLCATreeNode(node, 4, 5).data);
    }
}