package BinarySearchTree;

public class BuildTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(Node root,int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = buildTree(root.left, val);
        } else{
            root.right = buildTree(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean searchElem(Node root,int k){
        if(root == null){
            return false;
        }

        if(root.data == k){
            return true;
        }

        if(root.data > k){
            return searchElem(root.left, k);
        } else{
            return searchElem(root.right, k);
        }

    }

    public static Node deleteNode(Node root,int ele){

        if (root.data > ele) {
            root.left = deleteNode(root.left, ele);
        } else if (root.data < ele) {
            root.right = deleteNode(root.right, ele);
        } else {
            // 1. Zero child
            if (root.left == null && root.right == null) {
                return null;
            }

            // 2. Single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 3. Two child
            Node ISA = findInorderSuccessor(root.right);
            root.data = ISA.data;
            root.right = deleteNode(root.right, ISA.data);
        }
        return root;
      
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1){
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        int values2[] = {8,5,3,1,4,6,10,11,14};
/*      
            5
          /    \
         1      7
          \
            3
          /  \
         2    4

*/
        Node root = null;
        for(int i=0;i<values2.length;i++){
            root = buildTree(root, values2[i]);
        }
        inOrder(root);
        System.out.println();

        // System.out.println(searchElem(root, 6));
        // Node root2 = deleteNode(root, 10);
        // inOrder(root2);

        printInRange(root, 5, 10);

    }
}
