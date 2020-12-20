class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        long min = Long.MAX_VALUE, mid = Long.MAX_VALUE;
        for(int x: nums)
        {
            if(x <= min)
                min = x;
            else if(x <= mid)
                mid = x;
            else
                return true;
        }
        return false;
    }
}