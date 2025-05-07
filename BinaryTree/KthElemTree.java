public class KthElemTree {

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

    public static void findKthlevel(Node root,int level,int K){
        if(root == null){
            return;
        }

        if(level == K){
            System.out.print(root.data+" ");
            return;
        }

        findKthlevel(root.leftTree, level+1, K);
        findKthlevel(root.rightTree, level+1, K);

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
        findKthlevel(node, 1, 2);
    }
}
