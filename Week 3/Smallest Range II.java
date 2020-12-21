class Solution {
    public int smallestRangeII(int[] A, int K) {
        if(A == null || A.length < 2)
            return 0;
        Arrays.sort(A);
        int ans = A[A.length-1] - A[0];
        
        for(int i = 1; i < A.length; i++)
        {
            int min = Math.min(A[0]+K, A[i]-K);
            int max = Math.max(A[i-1]+K, A[A.length-1]-K);
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}