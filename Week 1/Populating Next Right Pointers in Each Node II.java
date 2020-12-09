/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++)
            {
                Node curr = q.poll();
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
                if(prev != null)
                    prev.next = curr;
                prev = curr;
            }
        }
        
        return root;
        
    }
}