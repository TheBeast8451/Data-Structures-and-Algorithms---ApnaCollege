
import java.util.ArrayList;

public class LowestCommonAncestor {
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

    public static boolean getPath(Node root,int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.leftTree, n, path);
        boolean foundRight = getPath(root.rightTree, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node findLCATree(Node root,int n1,int n2){
    // 1.Find path of root to node
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        
    // 2. Compare both arrays
        int i=0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        
        Node lca = path1.get(i-1);
        return lca;

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
        System.out.println(findLCATree(node, 4, 6).data);
    }
}