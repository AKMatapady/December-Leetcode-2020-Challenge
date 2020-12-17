class Solution {
    
    private HashMap<Integer, Integer> map;
    private int ans;
    
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) 
    {        
        return kSum(new int[][]{A, B, C, D});
    }
    
    public int kSum(int[][] arr)
    {
        map = new HashMap();
        ans = 0;
        populate(arr, 0, 0);
        return find(arr, arr.length/2, 0);
    }
    
    private void populate(int[][] arr, int index, int sum)
    {
        if(index < arr.length/2)
        {
            for(int x: arr[index])
            {
                populate(arr, index+1, sum+x);
            }
        }
        else
        {
            map.put((-sum), map.getOrDefault((-sum), 0)+1);
        }
    }
    
    private int find(int[][] arr, int index, int sum)
    {
        if(index >= arr.length)
        {
            ans += map.getOrDefault(sum, 0);
        }
        else
        {
            for(int x: arr[index])
            {
                find(arr, index+1, sum+x);
            }
        }
        return ans;
    }
    
}