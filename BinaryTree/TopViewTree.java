
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewTree {

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

    static class Info {

        int hd;
        Node node;

        public Info(Node node, int hd) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void printTopView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int max = 0, min = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info currNode = q.remove();
            if (currNode == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // First time my horizontal distance is occurs
                if (!map.containsKey(currNode.hd)) {
                    map.put(currNode.hd, currNode.node);
                }

                // Compare - left and right
                if (currNode.node.leftTree != null) {
                    q.add(new Info(currNode.node.leftTree, currNode.hd - 1));
                    min = Math.min(min, currNode.hd - 1);
                }

                if (currNode.node.rightTree != null) {
                    q.add(new Info(currNode.node.rightTree, currNode.hd + 1));
                    max = Math.max(max, currNode.hd + 1);
                }
            }

        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }

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
        printTopView(node);
    }
}
