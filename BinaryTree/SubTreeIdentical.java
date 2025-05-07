public class SubTreeIdentical {
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

    public static boolean isIdentical(Node node,Node subNode){
        if(node == null && subNode == null){
            return true;
        }
        if(node == null || subNode == null ||  node.data != subNode.data){
            return false;
        }

        if(!isIdentical(node.leftTree, subNode.leftTree)){
            return false;
        }

        if(!isIdentical(node.rightTree, subNode.rightTree)){
            return false;
        }
        return true;
        
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.leftTree, subRoot) || isSubtree(root.rightTree, subRoot);
    }

    public static void main(String[] args) {
        /*
                 1
               /  \
             2     3
            / \   / \
           4  5  6   7

        */
                
        Node node = new Node(1);
        node.leftTree = new Node(2);
        node.rightTree = new Node(3);
        node.leftTree.leftTree = new Node(4);
        node.leftTree.rightTree = new Node(5);
        node.rightTree.leftTree = new Node(6);
        node.rightTree.rightTree = new Node(7);

        /*

             2   
            / \  
           4  5 
            
        */
        Node sub = new Node(2);
        sub.leftTree = new Node(4);
        // sub.rightTree = new Node(5); 
        System.out.println(isSubtree(node, sub));
    }
}
