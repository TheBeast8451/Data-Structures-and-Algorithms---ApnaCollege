package BinarySearchTree;

public class delete {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
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

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
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
for(int i=0;i<values.length;i++){
    // root = buildTree(root, values[i]);

}
    }
}
