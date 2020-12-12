/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        List<TreeNode> last = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        //node -> its parent
        HashMap<TreeNode, TreeNode> map = new HashMap();
        map.put(root, null);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            //if(size > 0)
                last = new ArrayList();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                last.add(curr);
                if(curr.left != null)
                {
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }
        
        if(last.size() == 1)
            return last.get(0);
        
        Set<TreeNode> s1 = new HashSet();
        
        for(TreeNode t: last)
            s1.add(t);
        
        while(s1.size() > 1)
        {
            Set<TreeNode> s2 = s1;
            s1 = new HashSet();
            for(TreeNode t: s2)
            {
                TreeNode n = map.get(t);
                if(n == null)
                    return root;
                s1.add(n);
            }
        }
        
        return (new ArrayList<TreeNode>(s1)).get(0);
    }
}