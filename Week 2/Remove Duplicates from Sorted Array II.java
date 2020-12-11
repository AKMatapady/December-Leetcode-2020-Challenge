class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        if(nums.length < 3)
            return nums.length;
        int curr = nums[0], count = 1, j = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            if(j < i)
                nums[j] = nums[i];
            if(nums[i] != curr)
            {
                curr = nums[i];
                count = 1;
            }
            else
            {
                count++;
            }
            if(count < 3)
                j++;
        }
        return j;
    }
}