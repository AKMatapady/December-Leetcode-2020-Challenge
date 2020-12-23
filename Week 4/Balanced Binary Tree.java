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
    
    private int recur(TreeNode root)
    {
        if(!ans)
            return 0;
        if(root == null)
            return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        if(Math.abs(left-right) > 1)
            ans = false;
        return Math.max(left, right)+1;
    }
    
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        
        recur(root);
        
        return ans;
    }
}