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
    
    private boolean dfs(TreeNode root, long max, long min)
    {
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        
        if(dfs(root.left, root.val, min))
        {
            if(dfs(root.right, max, root.val))
                return true;
        }
        return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(dfs(root.left, root.val, (Integer.MIN_VALUE-((long)1))))
        {
            if(dfs(root.right, (Integer.MAX_VALUE+((long)1)), root.val))
                return true;
        }
        return false;
    }
}