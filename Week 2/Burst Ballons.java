class Solution {
    
    // private class sub
    // {
    //     int index;
    //     int val;
    //     sub(int idx, int value)
    //     {
    //         index = idx;
    //         val = value;
    //     }
    // }
    
    private int get(int[] nums, int index)
    {
        if(index < 1)
            return 1;
        if(index > nums.length)
            return 1;
        return nums[index-1];
    }
    
    public int maxCoins(int[] nums) {
        //int ans = 0;
        if(nums == null || nums.length < 1)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return ((nums[0]*nums[1])+Math.max(nums[0], nums[1]));
        
        int[][] dp = new int[nums.length+2][nums.length+2];
        
        for(int left = nums.length-1; left >= 0; left--)
        {
            for(int right = left+2; right <= nums.length+1; right++)
            {
                for(int curr = left+1; curr < right; curr++)
                {
                    dp[left][right] = Math.max(dp[left][right], get(nums, left) * get(nums, curr) * get(nums, right) + dp[left][curr] + dp[curr][right] );
                }
            }
        }
        
        return dp[0][nums.length+1];
    }
}