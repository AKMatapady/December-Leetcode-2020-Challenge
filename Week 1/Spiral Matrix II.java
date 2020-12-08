class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] ans = new int[n][n];
        int curr = 1;
        for(int i = 0; i < (n+1)/2; i++)
        {
            for(int j = i; j < n-i; j++)
                ans[i][j] = curr++;
            for(int j = i+1; j < n-i; j++)
                ans[j][n-1-i] = curr++;
            for(int j = n-2-i; j >= i; j--)
                ans[n-1-i][j] = curr++;
            for(int j = n-i-2; j > i; j--)
                ans[j][i] = curr++;
        }
        
        return ans;        
    }
}