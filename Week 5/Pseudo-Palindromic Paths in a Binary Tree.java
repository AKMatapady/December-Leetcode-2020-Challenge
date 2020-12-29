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
    
    private void recur(TreeNode root, HashMap<Integer, Integer> map)
    {
        if(root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        if(root.left == null && root.right == null)
        {
            int count = 0;
            for(int key: map.keySet())
            {
                if(map.get(key) % 2 == 1)
                    count++;
                if(count > 1)
                    break;
            }
            if(count < 2)
                ans++;
            map.put(root.val, map.get(root.val)-1);
            return;
        }
        recur(root.left, map);
        recur(root.right, map);
        map.put(root.val, map.get(root.val)-1);
    }
    
    int ans = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        recur(root, new HashMap<Integer, Integer>());
        return ans;
    }
}