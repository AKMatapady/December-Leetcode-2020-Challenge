class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        if(target < 2)
            return target;
        long x = 1, sum = 1;
        while(sum < target)
        {
            x++;
            sum += x;
        }
        while((sum-target)%2 == 1)
        {
            x++;
            sum += x;
        }
        return (int)x;
    }
}