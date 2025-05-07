
public class KthAncestor {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int findKthAncestors(Node root,int n,int K){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftSub = findKthAncestors(root.left, n, K);
        int rightSub = findKthAncestors(root.right, n, K);

        if(leftSub == -1 && rightSub == -1){
            return -1;
        }

        int max = Math.max(leftSub, rightSub);
        if(max+1 == K){
            System.out.println(root.data);
        }

        return max+1;
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
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        findKthAncestors(node, 5, 1);
    }
}
