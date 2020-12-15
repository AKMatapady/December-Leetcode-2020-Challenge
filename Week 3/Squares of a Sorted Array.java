class Solution {
    public int[] sortedSquares(int[] nums) {
        
        if(nums == null || nums.length < 1)
            return new int[0];
        
        int[] ans = new int[nums.length];
        
        //using Stack instead of a list will be a better approach
        List<Integer> pre = new ArrayList();
        int i = 0;
        while(i < nums.length && nums[i] < 0)
        {
            pre.add(nums[i]);
            i++;
        }
        
        int j = 0;
        
        while(j < nums.length)
        {
            if(pre.size() > 0)
            {
                int x = pre.get(pre.size()-1);
                if(i >= nums.length || (x*x) < (nums[i]*nums[i]))
                {
                    ans[j] = x*x;
                    pre.remove(pre.size()-1);
                }
                else
                {
                    ans[j] = (nums[i]*nums[i]);
                    i++;
                }
            }
            else
            {
                ans[j] = (nums[i]*nums[i]);
                i++;
            }
            j++;
        }
        
        return ans;        
    }
}