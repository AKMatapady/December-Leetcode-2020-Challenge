class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1)
            return;
        int r = board.length;
        int c = board[0].length;
        
        //0 -> dead
        //1 -> alive
        //-1 -> alive before but dead now
        //2 -> dead before but alive now
        
        int[][] coord = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                int count = 0;
                for(int[] xy: coord)
                {
                    int r1 = i + xy[0];
                    int c1 = j + xy[1];
                    if(r1 >= 0 && c1 >= 0 && r1 < r && c1 < c)
                    {
                        if(board[r1][c1] == 1 || board[r1][c1] == -1)
                            count++;
                    }
                    if(count > 3)
                        break;
                }
                if(board[i][j] == 1)
                {
                    if(count < 2 || count > 3)
                        board[i][j] = -1;
                }
                else
                {
                    if(count == 3)
                        board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(board[i][j] < 1)
                    board[i][j] = 0;
                else
                    board[i][j] = 1;
            }
        }
        
    }
}