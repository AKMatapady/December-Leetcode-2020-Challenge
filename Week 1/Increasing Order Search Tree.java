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
    
    //boolean start = false;
    TreeNode curr;
    
    private void recur(TreeNode root)
    {
        //TreeNode left, right;
        if(root.left != null)
            recur(root.left);
        
        curr.left = null;
        curr.right = root;
        curr = curr.right;
        curr.left = null;
        
        if(root.right != null)
        {
            recur(root.right);
        }
    }
    
    public TreeNode increasingBST(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null))
            return root;
        TreeNode head = new TreeNode();
        curr = head;
        recur(root);        
        return head.right;
    }
}