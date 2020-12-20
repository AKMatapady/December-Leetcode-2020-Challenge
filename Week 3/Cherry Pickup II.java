class Solution {
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1)
            return 0;
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        
        for(int i = 0; i < c; i++)
        {
            for(int j = 0; j < c; j++)
            {
                dp[r-1][i][j] = grid[r-1][i];
                if(i != j)
                    dp[r-1][i][j] += grid[r-1][j];
            }
        }
        
        for(int row = r-2; row >= 0; row--)
        {
            for(int i = 0; i < c; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    dp[row][i][j] = grid[row][i];
                    if(i != j)
                        dp[row][i][j] += grid[row][j];
                    
                    int[] cols = {-1, 0, 1};
                    int max = 0;
                    for(int x: cols)
                    {
                        for(int y: cols)
                        {
                            if(i+x >= 0 && i+x < c && j+y >= 0 && j+y < c)
                                max = Math.max(max, dp[row+1][i+x][j+y]);
                        }
                    }
                   dp[row][i][j] += max; 
                }
            }
        }
        
        return dp[0][0][c-1];
    }
}